package com.example.pokedexcompose.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexcompose.data.network.ApiBuilder
import com.example.pokedexcompose.data.network.GetServicePokemons
import com.example.pokedexcompose.ui.screens.ListPokemonScreen
import com.example.pokedexcompose.ui.screens.WelcomeScreen
import com.example.pokedexcompose.ui.viewmodels.ListPokemonViewModel

@Composable
fun AppNavigation() {
    val navController =  rememberNavController();

    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN, builder = {
        composable(Routes.WELCOME_SCREEN){

            WelcomeScreen(navController)
        }
        composable(Routes.POKEMON_LIST_SCREEN){
            val listPokemonViewModel : ListPokemonViewModel = viewModel(
                factory = ListPokemonViewModel.provideFactory(
                    GetServicePokemons(ApiBuilder.create())
                )
            )
            ListPokemonScreen(navController, listPokemonViewModel)
        }
    })
}