package com.ashutosh.splootapplication.Presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ashutosh.splootapplication.Data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    var phoneNo by mutableStateOf("")
    var password by mutableStateOf("")


    var name by mutableStateOf("")
    var typeRegister by mutableStateOf("")
    var phone by mutableStateOf("")
    var isVerified by mutableStateOf(true)

    var password1 by mutableStateOf("")
    var password2 by mutableStateOf("")

}