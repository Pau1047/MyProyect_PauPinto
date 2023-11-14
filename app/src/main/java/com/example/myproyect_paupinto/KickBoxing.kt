package com.example.myproyect_paupinto

import androidx.compose.runtime.Composable

@Composable
fun KickBoxing(){

}


data class InfoKickBoxing(
    val name: String,
    val imagen: Int,
    val peso: String,
    val titulos: String
)

fun getInfoKickBoxing(): List<InfoKickBoxing>{
    return listOf(
        InfoKickBoxing(
            "Artem Vakhitov",
            R.drawable.artemvakhitov,
            "95Kg",
            "Campeon del mundo en peso semipesado"
        ),
        InfoKickBoxing(
            "Alex Pereira",
            R.drawable.alexpereira,
            "85Kg",
            "Campeon del mundo en peso medio"
        ),
        InfoKickBoxing(
            "Harut Grigorian",
            R.drawable.harutgrigorian,
            "77Kg",
            "Campeon del mundo en peso wélter"
        ),
        InfoKickBoxing(
            "Sitthichai Sitsongpeenong",
            R.drawable.sitthichaisitsongpeenong,
            "70Kg",
            "Campeon del mundo en peso ligero"
        )


    )


}