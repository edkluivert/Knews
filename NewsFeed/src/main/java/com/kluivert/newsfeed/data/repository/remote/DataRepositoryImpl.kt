package com.kluivert.newsfeed.data.repository.remote

import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.data.network.api.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class DataRepositoryImpl

@Inject
constructor(
    private val newsApi: NewsApi
) : DataRepository
{
    override fun getNews(countryCode: String, pageNum: Int): Flow<News> {
        return flow {
            val newsResults = newsApi.getNews(countryCode,pageNum)
            emit(newsResults)
        }.flowOn(Dispatchers.IO)
    }

    override fun searchNews(countryCode: String, pageNum: Int): Flow<News> {
        return flow {
            val searchResults = newsApi.searchNews(countryCode,pageNum)
            emit(searchResults)
        }.flowOn(Dispatchers.IO)
    }


}