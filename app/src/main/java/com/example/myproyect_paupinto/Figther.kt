package com.example.myproyect_paupinto

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproyect_paupinto.ui.theme.Medio2
import com.example.myproyect_paupinto.ui.theme.fontcanter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Figther(navController: NavHostController, figtherViewModel: FigtherViewModel){

    Scaffold(floatingActionButton = { MyFAB(navController)}) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(bottom = it.calculateBottomPadding())
        ){
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
                Row(modifier = Modifier.fillMaxWidth().padding(top = 50.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                    Text(text = figtherViewModel.nameFigther,
                        fontFamily = fontcanter,
                        fontSize = 55.sp,
                        color = Color.White
                    )
                }
                Row(modifier = Modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    Divider()
                }
                Row(modifier = Modifier.fillMaxSize().padding(bottom = 300.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                    VideoYoutube(youtubeVideoId = figtherViewModel.urlFigther, lifecycleOwner = LocalLifecycleOwner.current)
                }
            }
        }
    }
}


@Composable
fun MyFAB(navController: NavHostController){
    val value by rememberInfiniteTransition().animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = LinearEasing
            )
        )
    )

    val colors = listOf(
        Color(0xFF2196F3),
        Color(0xFF002DFF),
        Color(0xFF7ED6FF),
        Color(0xFF04E3FF),
        Color(0xFF001170)
    )
    var gradientBrush by remember {
        mutableStateOf(
            Brush.horizontalGradient(
                colors = colors,
                startX = -10.0f,
                endX = 400.0f,
                tileMode = TileMode.Repeated
            )
        )
    }
    Box(modifier = Modifier
        .drawBehind {
            rotate(value) {
                drawCircle(
                    gradientBrush, style = Stroke(width = 12.dp.value)
                )
            }
        }
        .size(57.dp)
    ){
        FloatingActionButton(onClick = {navController.popBackStack()}, containerColor = Medio2, shape = CircleShape) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = " " )
        }
    }
}



