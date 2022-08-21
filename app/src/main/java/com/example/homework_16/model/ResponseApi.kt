package com.example.homework_16.model

import com.squareup.moshi.Json

data class ResponseApi(
    val data: List<Data>,
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    val support: Support,
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int
) {
    data class Data(
        val avatar: String,
        val email: String,
        @Json(name = "first_name")
        val firstName: String,
        val id: Int,
        @Json(name = "last_name")
        val lastName: String
    )

    data class Support(
        val text: String,
        val url: String
    )
}