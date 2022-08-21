package com.example.homework_16.api

import com.example.homework_16.model.ResponseApi
import com.example.homework_16.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharacters(): Response<ResponseApi>

}