package com.kluivert.newsfeed.data.repository.remote

import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.data.network.api.NewsApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


interface DataRepository
{

    fun getNews(countryCode : String,
                pageNum : Int):
                Flow<News>

    fun searchNews(countryCode : String ,
                    pageNum : Int):
                    Flow<News>


}