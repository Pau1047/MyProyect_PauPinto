package com.example.myproyect_paupinto

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproyect_paupinto.ui.theme.Claro2
import com.example.myproyect_paupinto.ui.theme.Claro3
import com.example.myproyect_paupinto.ui.theme.Medio
import com.example.myproyect_paupinto.ui.theme.Medio2
import com.example.myproyect_paupinto.ui.theme.Medio3
import com.example.myproyect_paupinto.ui.theme.fonthigh
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portada(navController: NavHostController, fighterViewModel: FighterViewModel){
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val brush = Brush.linearGradient(listOf(Claro2,Claro3 ,Medio, Medio2,
        Medio3))

    Scaffold(topBar = { MyTop(drawerState) }) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = it.calculateTopPadding()) ){
            MyModalDrawer(drawerState,scope,navController, fighterViewModel)

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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalDrawer(drawerState: DrawerState, scope: CoroutineScope, navController: NavHostController, fighterViewModel: FighterViewModel) {

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
                        fighterViewModel.setGrupo("KickBoxing")
                        })

                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.muaythai), contentDescription = "MuayThai")},label = {   Text(
                        text = "MuayThai", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        fighterViewModel.setGrupo("MuayThai")
                    })

                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.boxeo), contentDescription = "Boxeo")},label = {   Text(
                        text = "Boxeo", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        fighterViewModel.setGrupo("Boxeo")
                    })

                    NavigationDrawerItem(icon = {Icon(painterResource(id = R.drawable.mma), contentDescription = "MMA")},label = {   Text(
                        text = "MMA", modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) }, selected =false , onClick = {  scope.launch { drawerState.close() }
                        navController.navigate("Cartas")
                        fighterViewModel.setGrupo("MMA")
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
            var selectedImage by remember { mutableStateOf<ImageData?>(null) }
            val configuration = LocalConfiguration.current
            when (configuration.orientation) {
                Configuration.ORIENTATION_LANDSCAPE -> {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        content = {
                            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                                LazyRow(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .fillMaxWidth()
                                ) {
                                    items(getAboutData()) { about ->
                                        ItemAbout(imageData = about) {
                                            selectedImage = about
                                        }
                                    }

                                }
                                Divider()
                                Spacer(modifier = Modifier.height(25.dp))
                                Row {
                                    selectedImage?.let { imageData ->
                                        ImageDetail(
                                            imageData = imageData
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(25.dp))

                                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                                    Text(text = "Que son las Artes Marciales?", fontSize = 25.sp, fontFamily = fonthigh)


                                    Text(text = " Son prácticas y tradiciones cuyo objetivo es someter o defenderse mediante una técnica concreta.", fontSize = 20.sp)

                                    Text(text = "Beneficios", fontSize = 25.sp, fontFamily = fonthigh)

                                    Text(text = " Sin importar cuál se elija, todas tienen en común que con su práctica se puede lograr una reducción de peso, " +
                                            "tonificación muscular y un aumento en la resistencia cardiovascular. Y como complemento, se logra aumentar los niveles de balance," +
                                            " coordinación y flexibilidad.", fontSize = 20.sp)

                                    Text(text = "Donde practicarlas?", fontSize = 25.sp,fontFamily = fonthigh)

                                    Text(text = " Prestigioso gimnasio de kickboxing llamado AMC Castellón." ,fontSize = 20.sp)

                                }
                            }
                            }
                    )
                }
                else -> {
                    Scaffold(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 8.dp),
                        content = {
                            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                                LazyRow(
                                    modifier = Modifier
                                        .height(130.dp)
                                        .fillMaxWidth()
                                ) {
                                    items(getAboutData()) { about ->
                                        ItemAbout(imageData = about) {
                                            selectedImage = about
                                        }
                                    }

                                }
                                Divider()
                                Spacer(modifier = Modifier.height(25.dp))
                                Row {
                                    selectedImage?.let { imageData ->
                                        ImageDetail(
                                            imageData = imageData
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(25.dp))

                                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

                                    Text(text = "Que son las Artes Marciales?", fontSize = 25.sp, fontFamily = fonthigh)


                                    Text(text = " Son prácticas y tradiciones cuyo objetivo es someter o defenderse mediante una técnica concreta.", fontSize = 20.sp)

                                    Text(text = "Beneficios", fontSize = 25.sp, fontFamily = fonthigh)

                                    Text(text = " Sin importar cuál se elija, todas tienen en común que con su práctica se puede lograr una reducción de peso, " +
                                            "tonificación muscular y un aumento en la resistencia cardiovascular. Y como complemento, se logra aumentar los niveles de balance," +
                                            " coordinación y flexibilidad.", fontSize = 20.sp)

                                    Text(text = "Donde practicarlas?", fontSize = 25.sp,fontFamily = fonthigh)

                                    Text(text = " Prestigioso gimnasio de kickboxing llamado AMC Castellón." ,fontSize = 20.sp)

                                }
                            }
                        }
                    )
                }
            }
        }
    )
}

@Composable
fun ImageDetail(imageData: ImageData) {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageData.photo),
            contentDescription = " Image",
            modifier = Modifier
                .fillMaxSize()
        )
    }
}

data class ImageData(
    var photo: Int
)

fun getAboutData(): List<ImageData> {
    return listOf(
        ImageData(
            R.drawable.pau1
        ),
        ImageData(
            R.drawable.pau2
        ),
        ImageData(
            R.drawable.pau3
        ),
        ImageData(
            R.drawable.pau4
        )
    )
}

@Composable
fun ItemAbout(imageData: ImageData, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(180.dp)
            .padding(end = 5.dp)
            .clickable(onClick = onClick),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageData.photo),
            contentDescription = "Game Image",
            modifier = Modifier
                .fillMaxSize()
        )

    }
}