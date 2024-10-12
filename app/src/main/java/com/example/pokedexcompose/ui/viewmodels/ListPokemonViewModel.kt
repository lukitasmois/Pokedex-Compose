package com.example.pokedexcompose.ui.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.data.entities.Pokemon
import com.example.pokedexcompose.data.network.GetServicePokemons
import kotlinx.coroutines.launch

class ListPokemonViewModel(
    private val getPokemonsUseCase: GetServicePokemons
): ViewModel() {

    var Pokemons = mutableStateOf<List<Pokemon>>(listOf())

    fun loadPokemons() {

        viewModelScope.launch {
            val pokemons = getPokemonsUseCase.execute()
            if(pokemons.isNotEmpty()) {
                Pokemons.value = pokemons
                for (pokemon in pokemons){
                    Log.d("pokemons", pokemon.name)
                }
            }
        }
    }

    companion object {

        fun provideFactory(getPokemonsUseCase: GetServicePokemons): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ListPokemonViewModel(getPokemonsUseCase) as T
            }
        }
    }
}