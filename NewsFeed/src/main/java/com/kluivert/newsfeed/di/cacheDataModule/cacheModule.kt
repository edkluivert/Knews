package com.kluivert.newsfeed.di.cacheDataModule

import android.content.Context
import com.kluivert.newsfeed.data.cache.dao.NewsDao
import com.kluivert.newsfeed.data.cache.database.NewsDatabase
import com.kluivert.newsfeed.data.repository.local.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext



@InstallIn(ApplicationComponent::class)
@Module
object cacheModule {


    @Provides
    fun providesNewsDao(@ApplicationContext appContext: Context) : NewsDao {
        return NewsDatabase.getInstance(appContext).newsDao
    }

    @Provides
    fun providesNewsDBRepository(newsDao: NewsDao) = LocalRepository(newsDao)

}