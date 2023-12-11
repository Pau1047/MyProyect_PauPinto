package com.example.myproyect_paupinto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproyect_paupinto.ui.theme.MyProyect_PauPintoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val figtherViewModel: FigtherViewModel = viewModel()

            MyProyect_PauPintoTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController,startDestination = DestinationScreen.SplashScreenDest.route){
                        composable(route = DestinationScreen.SplashScreenDest.route){
                            SplashScreen(navController = navController)
                        }
                        composable("Portada"){Portada(navController,figtherViewModel)}
                        composable("Figther",
                            enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Down,
                                animationSpec = tween(800)
                            )}, exitTransition = { fadeOut(animationSpec = tween(500))})
                        { Figther(navController, figtherViewModel) }

                        composable("Cartas",
                            enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
                                animationSpec = tween(600)
                            )})
                        { Cartas(navController, figtherViewModel) }
                    }
                }
            }
        }
    }
}