package com.kluivert.newsfeed.data.network.api


import com.kluivert.newsfeed.BuildConfig
import com.kluivert.newsfeed.data.model.News
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {


    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") countryCode :String = "ng",
        @Query("page") pageNumber :Int = 1,
        @Query("apiKey") apiKey : String = BuildConfig.API_KEY
    ):News

    @GET("v2/everything")
    suspend fun searchNews(
      @Query("q") searchWord : String,
      @Query("page") pageNumber :Int = 1,
      @Query("apiKey") apiKey : String = BuildConfig.API_KEY

    ):News

}