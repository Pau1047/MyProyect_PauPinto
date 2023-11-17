package com.example.myproyect_paupinto


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Boxeo(navController: NavHostController){
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(topBar = { MyTop(drawerState) }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            MyModalDrawer(drawerState,scope,navController)
            LazyColumn {
                items(getInfoBoxeo()) { info ->
                    MyCard(infoBoxeo = info)
                }
            }
        }
    }
}

data class InfoBoxeo(
    val name: String,
    val imagen: Int,
    val peso: String,
    val titulos: String
)

fun getInfoBoxeo(): List<InfoBoxeo>{
    return listOf(
        InfoBoxeo(
            "Tyson Fury",
            R.drawable.tyson,
            "126Kg",
            "Campeon del mundo en peso completo"
        ),
        InfoBoxeo(
            "Canelo Álvarez",
            R.drawable.caneloalvarez,
            "85Kg",
            "Campeon del mundo en peso medio"
        ),
        InfoBoxeo(
            "Terence Crawford",
            R.drawable.terence,
            "66,5Kg",
            "Campeon del mundo en peso wélter"
        ),
        InfoBoxeo(
            "Devin Haney",
            R.drawable.devin,
            "61,2Kg",
            "Campeon del mundo en peso ligero"
        )
    )
}

@Composable
fun MyCard(infoBoxeo: InfoBoxeo) {
    var rating by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium

    ) {
        Column() {

            Image(painter = painterResource(id = infoBoxeo.imagen), contentDescription = "Imatge",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(text = infoBoxeo.name,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = infoBoxeo.titulos)

            Text(text = infoBoxeo.peso)

            Divider()

            RatingBar2(modifier = Modifier.padding(start = 20.dp),
                rating = rating,
                onRatingChanged = { newRating ->
                    rating = newRating
                })
        }
    }
}

@Composable
fun RatingBar2(
    modifier: Modifier = Modifier,
    rating: Int = 0,
    stars: Int = 5,
    onRatingChanged: (Int) -> Unit
) {
    Row(modifier = modifier) {
        repeat(stars) { starIndex ->
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = null,
                tint = if (starIndex < rating) Color.Black else Color.White,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .clickable { onRatingChanged(starIndex + 1) }
            )
        }
    }
}