package com.kluivert.newsfeed.ui.viewmodel.remoteViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.kluivert.newsfeed.data.repository.remote.DataRepository

class RemoteViewModel
@ViewModelInject
constructor(
    private val dataRepository: DataRepository
)  : ViewModel(){




}