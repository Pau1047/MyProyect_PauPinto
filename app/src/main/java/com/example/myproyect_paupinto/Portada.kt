package com.example.myproyect_paupinto

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myproyect_paupinto.ui.theme.Black
import com.example.myproyect_paupinto.ui.theme.Claro
import com.example.myproyect_paupinto.ui.theme.Claro2
import com.example.myproyect_paupinto.ui.theme.Claro3
import com.example.myproyect_paupinto.ui.theme.Medio
import com.example.myproyect_paupinto.ui.theme.Medio2
import com.example.myproyect_paupinto.ui.theme.Medio3
import com.example.myproyect_paupinto.ui.theme.Oscuro
import com.example.myproyect_paupinto.ui.theme.Oscuro2
import com.example.myproyect_paupinto.ui.theme.Oscuro3
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(navController: NavHostController, figtherViewModel: FigtherViewModel){
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(topBar = { MyTop(drawerState) }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding()) ){
            MyModalDrawer(drawerState,scope,navController, figtherViewModel)

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding()) ) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(drawerState: DrawerState){
    var scope = rememberCoroutineScope()
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Black),
        navigationIcon = {
            IconButton(onClick ={ scope.launch{
                if (drawerState.isClosed) {
                    drawerState.open()
                } else {
                    drawerState.close()
                }
            } }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        title = { Text(text = "Champion World", color = Color.White)  },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.White)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Options",
                    tint = Color.White)
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawer(drawerState: DrawerState, scope: CoroutineScope, navController: NavHostController, figtherViewModel: FigtherViewModel) {
    val brush = Brush.linearGradient(listOf(Claro, Claro2, Claro3 ,Medio, Medio2,
        Medio3 ,Oscuro, Oscuro2, Oscuro3, Black))

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
            .fillMaxSize()
            .background(brush)) {
                Column {
                    Row {
                        Text(text = "Que son las artes marciales?")
                    }
                    Row {
                        Text(text = "Cuales son los beneficios?")
                    }
                }
            }
        }
    )
}
