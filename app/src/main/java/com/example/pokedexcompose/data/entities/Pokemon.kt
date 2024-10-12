package com.example.pokedexcompose.data.entities

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name : String,
    @SerializedName("order")
    val id : Int,
    val sprites : Sprite
)
