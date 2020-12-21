package com.kluivert.newsfeed.ui.presenters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kluivert.newsfeed.R
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.databinding.FragmentBooksMarkBinding
import com.kluivert.newsfeed.databinding.FragmentFeedsBinding
import com.kluivert.newsfeed.ui.adapter.BookmarksAdapter
import com.kluivert.newsfeed.ui.adapter.FeedsAdapter
import com.kluivert.newsfeed.ui.viewmodel.localViewModel.LocalViewModel
import com.kluivert.newsfeed.ui.viewmodel.remoteViewModel.RemoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class BooksMark : Fragment() {

    private var  _binding  : FragmentBooksMarkBinding? = null

    private val binding get() = _binding!!

    private val bookmarksViewModel : LocalViewModel by viewModels()
    lateinit var adapter : BookmarksAdapter
    var bookmarklist: MutableList<Article> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBooksMarkBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.lifecycle.addObserver(bookmarksViewModel)
        adapter = BookmarksAdapter()
        binding.bookmarksRecycler.adapter = adapter
        binding.bookmarksRecycler.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        LinearLayoutManager.VERTICAL
                )
        )

        bookmarksViewModel.bookmarksFinalList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter.differ.submitList(it)
        })
        binding.bookmarksRecycler.smoothScrollToPosition(0)



    }


}