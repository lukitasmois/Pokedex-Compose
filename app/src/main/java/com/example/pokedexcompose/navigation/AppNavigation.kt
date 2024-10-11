package com.example.pokedexcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexcompose.ui.screens.ListPokemonScreen
import com.example.pokedexcompose.ui.screens.WelcomeScreen
import okhttp3.Route

@Composable
fun AppNavigation() {
    val navController =  rememberNavController();

    NavHost(navController = navController, startDestination = Routes.WELCOME_SCREEN, builder = {
        composable(Routes.WELCOME_SCREEN){
            WelcomeScreen(navController)
        }
        composable(Routes.POKEMON_LIST_SCREEN){
            ListPokemonScreen(navController)
        }
    })
}