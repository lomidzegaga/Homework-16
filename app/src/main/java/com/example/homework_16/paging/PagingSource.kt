package com.example.homework_16.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.homework_16.api.ApiService
import com.example.homework_16.model.ResponseApi

class PagingSource(private val apiService: ApiService) : PagingSource<Int, ResponseApi.Data>() {
    override fun getRefreshKey(state: PagingState<Int, ResponseApi.Data>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseApi.Data> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllCharacters()
            val responseData = mutableListOf<ResponseApi.Data>()
            val data = response.body()?.data ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}