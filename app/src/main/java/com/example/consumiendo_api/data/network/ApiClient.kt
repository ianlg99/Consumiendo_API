package com.example.consumiendo_api.data.network

import com.example.consumiendo_api.data.model.Characters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiClient {
    @GET
    suspend fun getAllCharacters(@Url url: String): Response<Characters>
}