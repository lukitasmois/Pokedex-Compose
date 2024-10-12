package com.example.pokedexcompose.data.entities

import com.google.gson.annotations.SerializedName

data class PokemonModelDefault (
    val name : String = "Nombre",
    @SerializedName("order")
    val id : Int = -1,
    val sprites : Sprite = Sprite("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png")
)

