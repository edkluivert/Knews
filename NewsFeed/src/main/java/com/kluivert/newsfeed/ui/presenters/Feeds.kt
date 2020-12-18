package com.kluivert.newsfeed.ui.presenters

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.inspirecoding.omdb_mvvm_kotlinflow_daggerhilt_retrofit.utils.showToast
import com.kluivert.newsfeed.R
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.databinding.FragmentFeedsBinding
import com.kluivert.newsfeed.ui.adapter.FeedsAdapter
import com.kluivert.newsfeed.ui.viewmodel.remoteViewModel.DataState
import com.kluivert.newsfeed.ui.viewmodel.remoteViewModel.RemoteViewModel
import com.kluivert.newsfeed.utils.Status
import com.kluivert.newsfeed.utils.gone
import com.kluivert.newsfeed.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class FeedsFrag : Fragment() {

    private var  _binding  : FragmentFeedsBinding? = null

    private val binding get() = _binding!!

    var newslist: MutableList<Article> = mutableListOf()
    private val feedsViewModel : RemoteViewModel by viewModels()
    lateinit var adapter : FeedsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFeedsBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



          getNews("ng",Integer.parseInt("1"))
          setupAdapter()
          setupNewsResultObserver()


    }

    private fun getNews(countryCode : String, pageNum : Int){

        lifecycleScope.launchWhenCreated {
            feedsViewModel.getNews(countryCode,pageNum)
        }
    }

    private fun setupNewsResultObserver() {
       feedsViewModel.newsResult.observe(viewLifecycleOwner, Observer { _result ->
            when(_result.status)
            {
                Status.SUCCESS -> {
                    _result._data?.let {
                       adapter.updateListItems(it)
                        Log.d(TAG, "${it.size}")
                        if(it.size > 0) {
                            isMovieFound(true)
                        } else {
                            isMovieFound(false)
                        }

                       // binding.motionLayout.transitionToEnd()
                    }

                 //   binding.swipeRefreshLayout.isRefreshing = false
                }
                Status.LOADING -> {
                   // binding.swipeRefreshLayout.isRefreshing = true
                }
                Status.ERROR -> {
                    _result.message?.let {
                        context?.showToast(it)
                    }
                   // binding.swipeRefreshLayout.isRefreshing = false
                }
            }
        })
    }

    private fun isMovieFound(found : Boolean) {

        if (found) {

            binding.feedsRecycler.visible()
            // binding.tvNoMovieFound.gone()

        } else {

            binding.feedsRecycler.gone()
            // binding.tvNoMovieFound.visible()

        }
    }

    fun setupAdapter(){
        adapter = FeedsAdapter(newslist)
        binding.feedsRecycler.adapter = adapter
        binding.feedsRecycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayoutManager.VERTICAL
            )
        )
    }

}