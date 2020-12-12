package com.kluivert.newsfeed.useCase

import com.kluivert.newsfeed.data.model.News
import com.kluivert.newsfeed.data.network.state.DataState
import com.kluivert.newsfeed.data.repository.remote.DataRepository
import javax.inject.Inject

class UseCase
@Inject
constructor(
    private val dataRepository: DataRepository
)
{


}