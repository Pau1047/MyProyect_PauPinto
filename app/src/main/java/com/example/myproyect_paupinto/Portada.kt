package com.example.myproyect_paupinto

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(navController: NavHostController){
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    Scaffold(topBar = { MyTop(drawerState) }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding()) ){
            MyModalDrawer(drawerState,scope,navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTop(drawerState: DrawerState){
    var scope = rememberCoroutineScope()
    TopAppBar(
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Blue),
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
fun MyModalDrawer(drawerState: DrawerState, scope: CoroutineScope, navController: NavHostController) {

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
                }
            }
        }
        ,content = {
            Box(modifier = Modifier
            .fillMaxSize()) {

        }
        } )

}
