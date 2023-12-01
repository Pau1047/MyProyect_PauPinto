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
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MMA(navController: NavHostController){
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(topBar = { MyTop(drawerState) }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            MyModalDrawerMMA(drawerState,scope,navController)
        }
    }
}

data class InfoMMA(
    val name: String,
    val imagen: Int,
    val peso: String,
    val titulos: String
)

fun getInfoMMA(): List<InfoMMA>{
    return listOf(
        InfoMMA(
            "Jon Jones",
            R.drawable.jonjones,
            "113g",
            "Campeon del mundo en pesado"
        ),
        InfoMMA(
            "Islam Makhachev",
            R.drawable.islam,
            "70Kg",
            "Campeon del mundo en peso ligero"
        ),
        InfoMMA(
            "Volkanovski",
            R.drawable.volkanovski,
            "69Kg",
            "Campeon del mundo en peso pluma"
        ),
        InfoMMA(
            "Sean O'Malley",
            R.drawable.sean,
            "61Kg",
            "Campeon del mundo en peso gallo"
        )
    )
}

@Composable
fun MyCard(infoMMA: InfoMMA) {
    var rating by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium

    ) {
        Column() {

            Image(painter = painterResource(id = infoMMA.imagen), contentDescription = "Imatge",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Text(text = infoMMA.name,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = infoMMA.titulos)

            Text(text = infoMMA.peso)

            Divider()

            RatingBar2(modifier = Modifier.padding(start = 20.dp),
                rating = rating,
                onRatingChanged = { newRating ->
                    rating = newRating
                })
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawerMMA(drawerState: DrawerState, scope: CoroutineScope, navController: NavHostController) {

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.amcportada), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)

                    NavigationDrawerItem(icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "KickBoxing")},label = {
                        Text(
                            text = "KickBoxing", modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) }, selected =false , onClick = { scope.launch { drawerState.close() }
                        navController.navigate("KickBoxing")})

                    NavigationDrawerItem(icon = {Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = "MuayThai")},label = {   Text(
                        text = "MuayThai", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("MuayThai")})

                    NavigationDrawerItem(icon = {Icon(imageVector = Icons.Filled.Star, contentDescription = "Boxeo")},label = {   Text(
                        text = "Boxeo", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Boxeo")})

                    NavigationDrawerItem(icon = {Icon(imageVector = Icons.Filled.Warning, contentDescription = "MMA")},label = {   Text(
                        text = "MMA", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("MMA")})

                    NavigationDrawerItem(icon = {Icon(imageVector = Icons.Filled.Warning, contentDescription = "Inicio")},label = {   Text(
                        text = "Inicio", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Portada")})
                }
            }
        }
        ,content = {
            Box(modifier = Modifier
                .fillMaxSize()) {
                LazyColumn {
                    items(getInfoMMA()) { info ->
                        MyCard(infoMMA = info)
                    }
                }
            }
        } )
}
