package com.kluivert.newsfeed.ui.viewmodel.remoteViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.data.repository.remote.DataRepository
import com.kluivert.newsfeed.utils.Resource
import com.kluivert.newsfeed.utils.TransitionStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

class RemoteViewModel
@ViewModelInject
constructor(
    private val dataRepository: DataRepository
)  : ViewModel(){


    private var newsList : ArrayList<Article> = ArrayList()

    //private val _transitionStatus = MutableStateFlow<TransitionStatus>(TransitionStatus.TRANSITION_INIT)
   // val transitionStatus : StateFlow<TransitionStatus> = _transitionStatus

    private val _newsResult = MutableLiveData<Resource<ArrayList<Article>>>()
    val newsResult : LiveData<Resource<ArrayList<Article>>> = _newsResult

   // fun setTransitionStatus(transitionStatus: TransitionStatus) {
     //   _transitionStatus.value = transitionStatus
   // }


    fun getNews(countryCode : String, pageNUm : Int){
        viewModelScope.launch(Dispatchers.IO) {

            newsList.clear()

            dataRepository.getNews(countryCode, pageNUm).
            onStart {
                _newsResult.postValue(Resource.Loading(true))

            }.catch { exception ->
                        exception.message?.let {
                            _newsResult.postValue(Resource.Error(it))
                        }
                    }.collect {_newsList->
                _newsList.articles?.let { listOfArticles ->
                    newsList.addAll(listOfArticles)


                    _newsResult.postValue(Resource.Success(newsList))
                }
                    }

        }
    }

}



sealed class DataState{
    data class Success(val articles : List<Article>):DataState()

    data class Error(val message: String) : DataState()

    object Loading : DataState()
}