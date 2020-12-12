package com.kluivert.newsfeed.data.network.state
 sealed class DataState {

     object Success:DataState()

     class Error(val message: String) : DataState()

     object Loading : DataState()

}