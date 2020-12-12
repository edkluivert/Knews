package com.kluivert.newsfeed.ui.presenters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kluivert.newsfeed.R
import com.kluivert.newsfeed.databinding.FragmentFeedsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FeedsFrag : Fragment() {

    private var  _binding  : FragmentFeedsBinding? = null

    private val binding get() = _binding!!

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


    }


}