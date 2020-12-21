package com.kluivert.newsfeed.ui.viewmodel.localViewModel

import androidx.hilt.lifecycle.ViewModelInject
import com.kluivert.newsfeed.data.model.Article
import com.kluivert.newsfeed.data.repository.local.LocalRepository
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocalViewModel
@ViewModelInject
constructor(private val localRepository: LocalRepository) : ViewModel(), LifecycleObserver{


    private val insertedId = MutableLiveData<Long>()
    var bookmarksFinalList: LiveData<List<Article>> =
            MutableLiveData<List<Article>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getBookmarks() {
        viewModelScope.launch {
           bookmarksFinalList = localRepository.getBookmarks()
        }
    }

    suspend fun addsBookmarks(article: Article){
        viewModelScope.launch(Dispatchers.IO) {
            localRepository.addBookmarks(article)
        }
    }

    suspend fun deleteBookmarks(article: Article){
        viewModelScope.launch(Dispatchers.IO) {
            localRepository.deleteBookmarks(article)
        }
    }

}