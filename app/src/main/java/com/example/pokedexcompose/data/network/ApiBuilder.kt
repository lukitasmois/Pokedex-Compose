package com.example.pokedexcompose.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}