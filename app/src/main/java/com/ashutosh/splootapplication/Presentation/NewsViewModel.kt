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
    var isOpenFolderClick by mutableStateOf(false)
    var name by mutableStateOf("")
}