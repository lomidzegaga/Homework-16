package com.example.homework_16.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.homework_16.api.ApiService
import com.example.homework_16.paging.PagingSource

class MainViewModel (private val apiService : ApiService) : ViewModel(){
    val listData = Pager(PagingConfig(
        pageSize = 1
    )) {
        PagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}