package com.example.myproyect_paupinto

import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproyect_paupinto.ui.theme.fontcanter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cartas(navController: NavHostController, figtherViewModel: FigtherViewModel){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(topBar = { MyTop(drawerState) }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())
        ) {
            MyModalDrawerKick(drawerState, scope, navController, figtherViewModel)
        }
    }
}

@Composable
fun MyCard(infoFigther: InfoFigther, figtherViewModel: FigtherViewModel, navController: NavHostController) {
    var rating by remember { mutableStateOf(0) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp)
            .clickable {
                figtherViewModel.setName(infoFigther.name)
                figtherViewModel.setUrl(infoFigther.url)
                navController.navigate("Figther")
            },
        shape = MaterialTheme.shapes.medium,

        ) {
        Column(modifier = Modifier.background(Color.LightGray)) {

            Image(
                painter = painterResource(id = infoFigther.imagen),
                contentDescription = "Imatge",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically ){
                Text(
                    text = infoFigther.name,
                    fontFamily = fontcanter,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(text = infoFigther.titulos)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = infoFigther.peso)
            Spacer(modifier = Modifier.height(5.dp))

            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically ){
                RatingBar(modifier = Modifier.padding(start = 20.dp),
                    rating = rating,
                    onRatingChanged = { newRating ->
                        rating = newRating
                    }
                )
            }
        }
    }
}

@Composable
fun RatingBar(
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawerKick(drawerState: DrawerState, scope: CoroutineScope, navController: NavHostController, figtherViewModel: FigtherViewModel) {

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column(modifier = Modifier.padding(8.dp)) {
                    Image(painter = painterResource(id = R.drawable.amcportada), contentDescription = "", modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)

                    NavigationDrawerItem(icon = { Icon(painterResource(id = R.drawable.kickboxing) , contentDescription = "KickBoxing")},label = {
                        Text(
                            text = "KickBoxing", modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) }, selected =false , onClick = { scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        figtherViewModel.setGrupo("KickBoxing")
                    })

                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.muaythai), contentDescription = "MuayThai")},label = {   Text(
                        text = "MuayThai", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        figtherViewModel.setGrupo("MuayThai")
                    })

                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.boxeo), contentDescription = "Boxeo")},label = {   Text(
                        text = "Boxeo", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        figtherViewModel.setGrupo("Boxeo")
                    })

                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.mma), contentDescription = "MMA")},label = {   Text(
                        text = "MMA", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        figtherViewModel.setGrupo("MMA")
                    })


                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.trofeo), contentDescription = "Inicio")},label = {   Text(
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
                    items(getInfoFigther()) { info ->
                        when(figtherViewModel.grupoFigther) {
                            "MuayThai" -> {if (info.grupo == "MuayThai")MyCard(info, figtherViewModel, navController) }
                            "MMA"-> {if (info.grupo == "MMA")MyCard(info, figtherViewModel, navController) }
                            "KickBoxing" -> {if (info.grupo == "KickBoxing")MyCard(info, figtherViewModel, navController) }
                            "Boxeo" -> {if (info.grupo == "Boxeo")MyCard(info, figtherViewModel, navController) }
                        }
                    }
                }

            }
        }
    )
}
