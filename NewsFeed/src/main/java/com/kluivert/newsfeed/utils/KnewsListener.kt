package com.kluivert.newsfeed.utils

import com.kluivert.newsfeed.data.model.Article


interface KnewsListener {


    suspend fun likelistener(article: Article, position: Int)

    suspend fun unlikeListener(article: Article, position: Int)

    suspend fun shareLIstener(article: Article,position: Int)

}