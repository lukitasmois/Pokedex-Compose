package com.example.pokedexcompose.data.network.models

data class PokemonResponseModel(
    val count : Int,
    val next : String,
    val previous: String,
    val results : List<PokemonResultsModel>
)
