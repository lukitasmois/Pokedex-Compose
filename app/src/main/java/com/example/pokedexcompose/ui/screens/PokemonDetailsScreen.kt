package com.example.pokedexcompose.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedexcompose.data.entities.PokemonModelDefault
import com.example.pokedexcompose.ui.viewmodels.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(pokemonId: Int, pokemonDetailsViewModel: PokemonDetailsViewModel){
    LaunchedEffect(Unit) {
        pokemonDetailsViewModel.loadPokemon(pokemonId)
    }

    val pokemon = pokemonDetailsViewModel.Pokemon.value

    if(pokemon == null){
        Text("Loading Pokemon...")
        return
    }else{
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = pokemon.sprites.front_default,
                contentDescription = "sprite",
                modifier = Modifier.size(250.dp),
                contentScale = ContentScale.Crop
            )
            Text(pokemon.name)
        }
    }
}