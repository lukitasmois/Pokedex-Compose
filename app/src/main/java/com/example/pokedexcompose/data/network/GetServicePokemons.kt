package com.example.pokedexcompose.data.network

import com.example.pokedexcompose.data.entities.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GetServicePokemons(
    private val apiService: ApiService
) {
    private val pokemonList: MutableList<Pokemon> = ArrayList()

    suspend fun getPokemons(): MutableList<Pokemon> {
        val pokemonList : MutableList<Pokemon> = ArrayList()

        withContext(Dispatchers.IO) {
        //val response = apiService.getPokemons()
            for(i in 0..21){
                //response.body()?.results?.get(19)?.name?.let { Log.d("response", it) }
                var response = apiService.getPokemon(i)
                if (response.isSuccessful){
                    response.body()?.let { pokemonList.add(it) }
                }
            }

        }

        return pokemonList
    }

    suspend fun getPokemon(id: Int): Pokemon? {
        var pokemon: Pokemon? = null
        withContext(Dispatchers.IO) {
            val response = apiService.getPokemon(id)
            if (response.isSuccessful) {
                pokemon = response.body()
            }
        }
        return pokemon
    }
}

