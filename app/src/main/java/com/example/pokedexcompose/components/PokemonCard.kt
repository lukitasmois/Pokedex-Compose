package com.example.pokedexcompose.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedexcompose.R
import com.example.pokedexcompose.data.entities.Pokemon
import com.example.pokedexcompose.navigation.AppNavigation

@Composable
//fun PokemonCard(id: String, name: String, image: String ){
fun PokemonCard(item : Pokemon, onClick: () -> Unit ){
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.width(250.dp)
            .padding(10.dp)
            .clickable { onClick() }

    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            Column {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Nombre",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = "${item.name} ",
                    fontSize = 15.sp
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = "ID: ${item.id} ",
                     fontSize = 15.sp
                )
            }
            AsyncImage(
                model = item.sprites.front_default,
                contentDescription = "sprite",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(150.dp)
                )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    //PokemonCard("1", "nombre", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png")
}