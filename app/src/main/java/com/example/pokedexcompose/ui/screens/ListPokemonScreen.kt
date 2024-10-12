package com.example.pokedexcompose.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pokedexcompose.components.PokemonCard
import com.example.pokedexcompose.ui.viewmodels.ListPokemonViewModel


@Composable
fun ListPokemonScreen(navController: NavController, listPokemonViewModel: ListPokemonViewModel){
    val pokemons by listPokemonViewModel.Pokemons

    LaunchedEffect(Unit) {
        listPokemonViewModel.loadPokemons()

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Lista de Pokemones")
        //PokemonCard("1", "nombre", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png")
        LazyColumn {
            items(pokemons){
                PokemonCard(item = it)
            }
        }
    }
}
