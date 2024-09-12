package com.ashutosh.splootapplication.NetworkModule


import com.ashutosh.splootapplication.NetworkModule.Model.TopNewsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface newsApi {
    @Headers("Content-Type: application/json")
    @GET("/v2/top-headlines")
    suspend fun getTopNews(
        @Query("country") country: String ,
        @Query("apiKey") apiKey: String ,
    ): Response<TopNewsResponse>
}