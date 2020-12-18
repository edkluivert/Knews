package com.kluivert.newsfeed.di.repositoryModule

import com.kluivert.newsfeed.data.network.api.NewsApi
import com.kluivert.newsfeed.data.repository.remote.DataRepository
import com.kluivert.newsfeed.data.repository.remote.DataRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesDataRepo(dataRepositoryImpl: DataRepositoryImpl):DataRepository
}