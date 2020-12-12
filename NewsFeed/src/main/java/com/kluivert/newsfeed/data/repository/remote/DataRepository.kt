package com.kluivert.newsfeed.data.repository.remote

import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.data.network.api.NewsApi
import javax.inject.Inject


class DataRepository

@Inject
constructor(
    private val newsApi: NewsApi
)
{

    suspend fun getNews(countryCode : String , pageNum : Int):List<News>{
        return newsApi.getNews(countryCode,pageNum)
    }

    suspend fun searchNews(countryCode : String , pageNum : Int):List<News>{
        return newsApi.searchNews(countryCode,pageNum)
    }


}