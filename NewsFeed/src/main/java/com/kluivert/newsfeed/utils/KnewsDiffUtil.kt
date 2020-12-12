package com.kluivert.newsfeed.utils

import androidx.recyclerview.widget.DiffUtil
import com.kluivert.newsfeed.data.model.Article


class KnewsDiffUtil(
    private val oldList: MutableList<Article>,
    private val newList: MutableList<Article>
) : DiffUtil.Callback() {


    override fun getOldListSize() = oldList.size


    override fun getNewListSize() = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition].id == newList[newItemPosition].id


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}