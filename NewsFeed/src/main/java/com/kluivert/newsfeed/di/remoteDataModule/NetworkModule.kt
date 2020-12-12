package com.kluivert.newsfeed.di.remoteDataModule

import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.data.network.api.NewsApi
import com.kluivert.newsfeed.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {


    @Provides
    fun providesBaseUrl():String{
        return Constants.BASE_URL
    }

    @Provides
    fun providesLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun providesOkHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logger)
        okHttpClient.callTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        val okhttp = okHttpClient.build()
        return okhttp

    }


    @Provides
    fun providesConverterFactory(): Converter.Factory{
        return MoshiConverterFactory.create()
    }


    @Provides
    fun providesApi(baseUrl : String, converter : Converter.Factory, okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converter)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit) : NewsApi{
        return retrofit.create(NewsApi::class.java)

    }

}