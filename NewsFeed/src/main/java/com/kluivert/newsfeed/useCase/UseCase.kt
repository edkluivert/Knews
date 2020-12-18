package com.kluivert.newsfeed.useCase

import com.kluivert.newsfeed.data.repository.remote.DataRepositoryImpl
import javax.inject.Inject

class UseCase
@Inject
constructor(
    private val dataRepositoryImpl: DataRepositoryImpl
)
{


}