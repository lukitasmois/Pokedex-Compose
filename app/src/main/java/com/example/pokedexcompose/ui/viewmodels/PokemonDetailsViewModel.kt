package com.example.pokedexcompose.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.data.entities.Pokemon
import com.example.pokedexcompose.data.network.GetServicePokemons
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    private val getPokemonsUseCase: GetServicePokemons)
    :ViewModel() {
        var Pokemon = mutableStateOf<Pokemon?>(null)

    fun loadPokemon(pokemonId: Int) {
        viewModelScope.launch {
            val pokemon = getPokemonsUseCase.getPokemon(pokemonId)
            if(pokemon != null) {
                Pokemon.value = pokemon
            }
        }
    }


    companion object {
        fun provideFactory(getPokemonsUseCase: GetServicePokemons): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PokemonDetailsViewModel(getPokemonsUseCase) as T
            }
        }
    }


}

