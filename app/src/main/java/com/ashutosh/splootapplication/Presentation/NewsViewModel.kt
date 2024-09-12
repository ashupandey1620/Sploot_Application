package com.ashutosh.splootapplication.Presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh.splootapplication.Data.Repository
import com.ashutosh.splootapplication.NetworkModule.Model.TopNewsResponse
import com.ashutosh.splootapplication.NetworkModule.NetworkResult
import com.ashutosh.splootapplication.Util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Date
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    var isOpenFolderClick by mutableStateOf(false)
    var name by mutableStateOf("")


    private val _topNewsResult = MutableStateFlow<NetworkResult<TopNewsResponse>>(NetworkResult.Loading)
    val topNewsResult: StateFlow<NetworkResult<TopNewsResponse>> = _topNewsResult


    fun getTopNews() {
        val country = "us"
        viewModelScope.launch {
            repository.topNews(country, Constants.API_KEY)
                .onStart {
                    _topNewsResult.value = NetworkResult.Loading
                }
                .catch { e ->
                    _topNewsResult.value = NetworkResult.Error(e.message ?: "Unknown error")
                }
                .collect { result ->
                    _topNewsResult.value =  result
                    if (result is NetworkResult.Success) {
                        result.data?.let { response ->
                            Log.d("Top_News",response.toString())
                        }
                    }
                }
        } 
    }


}