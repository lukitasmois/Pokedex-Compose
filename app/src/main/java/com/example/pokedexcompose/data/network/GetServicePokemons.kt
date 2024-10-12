package com.example.pokedexcompose.data.network

import android.util.Log
import com.example.pokedexcompose.data.entities.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class GetServicePokemons(
    private val apiService: ApiService
) {
    private val pokemonList: MutableList<Pokemon> = ArrayList()


//    suspend fun execute(): List<Pokemon> {
//        withContext(Dispatchers.IO) {
//        val response = apiService.getPokemons()
//            if(response.isSuccessful){
//                response.body()?.results?.get(19)?.name?.let { Log.d("response", it) }
//            }else{
//                Log.d("response", "no ok")
//            }
//
//        }
//
//        return emptyList()
//    }

    suspend fun execute(): MutableList<Pokemon> {
        val pokemonList : MutableList<Pokemon> = ArrayList()

        withContext(Dispatchers.IO) {
        //val response = apiService.getPokemons()
            for(i in 0..9){
                //response.body()?.results?.get(19)?.name?.let { Log.d("response", it) }
                var response = apiService.getPokemon(i)
                if (response.isSuccessful){
                    response.body()?.let { pokemonList.add(it) }
                }
            }

        }

        return pokemonList
    }
}

