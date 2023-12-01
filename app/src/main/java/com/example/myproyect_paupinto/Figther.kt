package com.example.myproyect_paupinto

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.navigation.NavHostController

@Composable
fun Figther(navController: NavHostController, figtherViewModel: FigtherViewModel){

    Column(modifier = Modifier.fillMaxSize()){
        Row {
            Text(text = figtherViewModel.nameFigther )
        }
        Row {
            VideoYoutube(youtubeVideoId = "R9_UrETCCOw", lifecycleOwner = LocalLifecycleOwner.current)
        }
    }

}