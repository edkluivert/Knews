package com.kluivert.newsfeed.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.kluivert.newsfeed.R
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.databinding.ItemBookmarksBinding
import com.kluivert.newsfeed.databinding.NewsItemBinding
import com.kluivert.newsfeed.utils.KnewsDiffUtil

class BookmarksAdapter(


) : RecyclerView.Adapter<BookmarksAdapter.BookmarksAdapterViewHolder>(){


 private val differCallback = object : DiffUtil.ItemCallback<Article>(){
     override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
         return oldItem.id == newItem.id
     }

     override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem == newItem
     }


 }

    val differ = AsyncListDiffer(this,differCallback)

    inner class BookmarksAdapterViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val binding = ItemBookmarksBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarksAdapterViewHolder {
        return BookmarksAdapterViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_bookmarks, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookmarksAdapterViewHolder, position: Int) {
         val current = differ.currentList[position]

        holder.binding.apply {
           bmImg.load(current.urlToImage)
           bmTitle.text = current.title
           bmDesc.text = current.description

         setOnItemClickListener {
             onItemClickListener?.let {
                 it(current)
             }
         }
        }
    }

    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener : (Article) -> Unit){
        onItemClickListener = listener

    }

    override fun getItemCount(): Int {
       return differ.currentList.size
    }

}