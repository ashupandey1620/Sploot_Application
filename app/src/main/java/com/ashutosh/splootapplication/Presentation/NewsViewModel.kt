package com.ashutosh.splootapplication.Presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashutosh.fsd.ui.theme.Theme.MainEvent
import com.ashutosh.fsd.ui.theme.Theme.MainState
import com.ashutosh.splootapplication.Data.News.Dao.News
import com.ashutosh.splootapplication.Data.Repository
import com.ashutosh.splootapplication.NetworkModule.Model.TopNewsResponse
import com.ashutosh.splootapplication.NetworkModule.NetworkResult
import com.ashutosh.splootapplication.newsApp
import com.ashutosh.splootapplication.Util.Constants

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch

import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    var selectID by mutableStateOf("")
    var isOpenFolderClick by mutableStateOf(false)
    var name by mutableStateOf("")
    var appState by mutableStateOf(MainState())
    private val _topNewsResult = MutableStateFlow<NetworkResult<TopNewsResponse>>(NetworkResult.Loading)
    val topNewsResult: StateFlow<NetworkResult<TopNewsResponse>> = _topNewsResult

    private val newsDao = newsApp.database.newsDao()

    private val _getNews = MutableLiveData<List<News>>()
    val getNews: LiveData<List<News>> = _getNews


    init {
        viewModelScope.launch {
            getNewsFromDatabase().collect { articles ->
                _getNews.value = articles
            }
        }
    }


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

                            val news = response.articles.map { data ->

                                News(
                                    data.author?:"Not Assigned",
                                    data.content?:"Not Assigned",
                                    data.description?:"Not Assigned",
                                    data.publishedAt?:"Not Assigned",
                                    data.source.name?:"Not Assigned",
                                    data.title?:"Not Assigned",
                                    data.url?:"Not Assigned",
                                    data.urlToImage?:"Not Assigned"
                                )

                            }
                            insertOrUpdateNewsInDatabase(news)
                        }
                    }
                }
        } 
    }


    private val _newsItem = MutableStateFlow<News?>(null)
    val newsItem: StateFlow<News?> = _newsItem


    fun getNewsByUrl(url: String) {
        viewModelScope.launch {
            val news = newsDao.getNewsByUrl(url)
            _newsItem.value = news
        }
    }




    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.UpdateAppTheme -> {
                viewModelScope.launch {
                    appState = appState.copy(theme = event.theme)
                }
            }
        }
    }

    private  fun getNewsFromDatabase(): Flow<List<News>> {
        return newsDao.getAllItems()
    }

    private suspend fun insertOrUpdateNewsInDatabase(news: List<News>) {
        Log.d("News Inserted","---------Done--------")
        newsDao.insertNews(news)
    }

}