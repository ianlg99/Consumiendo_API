package com.example.consumiendo_api.data.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(
                GsonConverterFactory.create())
            .build()
    }

    val retrofitService by lazy {
        retrofit.create(ApiClient::class.java)
    }
}