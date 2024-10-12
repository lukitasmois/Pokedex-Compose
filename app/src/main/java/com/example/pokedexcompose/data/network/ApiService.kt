package com.example.pokedexcompose.data.network

import com.example.pokedexcompose.data.entities.Pokemon
import com.example.pokedexcompose.data.network.models.PokemonResponseModel
import com.example.pokedexcompose.data.network.models.PokemonResultsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("pokemon/")
    suspend fun getPokemons(): Response<PokemonResponseModel>

    @GET("pokemon-form/{id}")
    suspend fun getPokemon(@Path("id") id : Int) : Response<Pokemon>
}