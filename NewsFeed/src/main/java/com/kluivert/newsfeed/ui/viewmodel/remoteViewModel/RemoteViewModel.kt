package com.kluivert.newsfeed.ui.viewmodel.remoteViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kluivert.newsfeed.data.network.state.DataState
import com.kluivert.newsfeed.data.repository.remote.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RemoteViewModel
@ViewModelInject
constructor(
    private val dataRepository: DataRepository
)  : ViewModel(){

    private val _dataState = MutableStateFlow<DataState>(DataState.Loading)

    val dataState : StateFlow<DataState> = _dataState

    fun getNews(countryCode : String, pageNum : Int){
        viewModelScope.launch(Dispatchers.IO) {
            _dataState.value = DataState.Loading

            if(dataRepository.getNews(countryCode,pageNum).isNullOrEmpty()){
                _dataState.value = DataState.Success
                dataRepository.getNews(countryCode,pageNum)
            }else{
                _dataState.value = DataState.Error("Error occured")
            }


        }
    }


}