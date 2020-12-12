package com.kluivert.newsfeed.data.repository.local

import com.kluivert.newsfeed.data.cache.dao.NewsDao
import com.kluivert.newsfeed.data.model.Article
import javax.inject.Inject

class LocalRepository

@Inject
constructor(
    private val newsDao: NewsDao
){

    suspend fun addBookmarks(article: Article){
        newsDao.addBookMarks(article)
    }

    suspend fun deleteBookmarks(article: Article){
        newsDao.deleteBookmarks(article)
    }

    suspend fun getBookmarks() = newsDao.getBookmarks()

}