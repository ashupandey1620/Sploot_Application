package com.ashutosh.splootapplication.Data

import com.ashutosh.splootapplication.NetworkModule.Model.TopNewsResponse
import com.ashutosh.splootapplication.NetworkModule.NetworkResult
import com.ashutosh.splootapplication.NetworkModule.newsApi
import com.ashutosh.splootapplication.NetworkModule.result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val api : newsApi) {

    suspend fun topNews(country:String,apikey:String): Flow<NetworkResult<TopNewsResponse>>
    = result{
        api.getTopNews(country,apikey)
    }

}