package com.ashutosh.splootapplication.NetworkModule


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException
N

fun<T> result(call:suspend () -> Response<T>):Flow<NetworkResult<T>> = flow {
    emit(NetworkResult.Loading)
    try{
        val c = call()
        c.let {
            if (c.isSuccessful){
                emit(NetworkResult.Success(it.body()))
            } else {
                c.errorBody()?.let { error ->
                    error.close()
                    emit(NetworkResult.Error(error.toString()))
                }
            }
        }
    }catch (e: IOException) {
        NetworkResult.NetworkError
    } catch (t:Throwable){
        t.printStackTrace()
        emit(NetworkResult.Error(t.message.toString()))
    }

}