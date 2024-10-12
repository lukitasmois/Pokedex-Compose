package com.example.pokedexcompose.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pokedexcompose.ui.viewmodels.ListPokemonViewModel


@Composable
fun ListPokemonScreen(navController: NavController, listPokemonViewModel: ListPokemonViewModel){
    LaunchedEffect(Unit) {
        listPokemonViewModel.loadPokemons()

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Lista de Pokemones")
        LazyColumn {

        }
    }
}
