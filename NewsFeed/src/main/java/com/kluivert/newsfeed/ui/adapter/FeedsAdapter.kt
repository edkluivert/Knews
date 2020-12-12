package com.kluivert.newsfeed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kluivert.newsfeed.R
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.databinding.NewsItemBinding
import com.kluivert.newsfeed.utils.KnewsDiffUtil

class FeedsAdapter(

    val newslist: MutableList<Article>

) : RecyclerView.Adapter<FeedsAdapter.FeedsAdapterViewHolder>(){


    fun updateListItems(newList: MutableList<Article>) {

        val diffCallback = KnewsDiffUtil(newslist, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

       newslist.clear()
      newslist.addAll(newList)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class FeedsAdapterViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val binding = NewsItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsAdapterViewHolder {
        return FeedsAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FeedsAdapterViewHolder, position: Int) {

      with(holder){


      }

    }

    override fun getItemCount(): Int {
        return newslist.size
    }

}