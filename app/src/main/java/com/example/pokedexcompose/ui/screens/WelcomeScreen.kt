package com.example.pokedexcompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pokedexcompose.navigation.Routes

@Composable
fun WelcomeScreen(navController: NavController) {
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
    Text("Bienvenido a la pokedex con compose!!")
    Button(onClick = {
        navController.navigate(route = Routes.POKEMON_LIST_SCREEN)
    }) {
        Text(text = "Ver Listas de pokemons")
    }
}
}