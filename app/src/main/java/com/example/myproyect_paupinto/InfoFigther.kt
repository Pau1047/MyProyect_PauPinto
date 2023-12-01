package com.example.myproyect_paupinto

data class InfoFigther(
    val name: String,
    val imagen: Int,
    val peso: String,
    val titulos: String,
    val url: String,
    val grupo: String
)

fun getInfoFigther(): List<InfoFigther>{

        return listOf(
            InfoFigther(
                "Artem Vakhitov",
                R.drawable.artemvakhitov,
                "95Kg",
                "Campeon del mundo en peso semipesado",
                "f",
                "KickBoxing"
            ),
            InfoFigther(
                "Alex Pereira",
                R.drawable.alexpereira,
                "85Kg",
                "Campeon del mundo en peso medio",
                "ed",
                "KickBoxing"
            ),
            InfoFigther(
                "Harut Grigorian",
                R.drawable.harutgrigorian,
                "77Kg",
                "Campeon del mundo en peso wélter",
                "d",
                "KickBoxing"
            ),
            InfoFigther(
                "Sitthichai",
                R.drawable.sitthichaisitsongpeenong,
                "70Kg",
                "Campeon del mundo en peso ligero",
                "f",
                "KickBoxing"
            ),
            InfoFigther(
                "Jon Jones",
                R.drawable.jonjones,
                "113g",
                "Campeon del mundo en pesado",
                "d",
                "MMA"
            ),
            InfoFigther(
                "Islam Makhachev",
                R.drawable.islam,
                "70Kg",
                "Campeon del mundo en peso ligero",
                "I",
                "MMA"
            ),
            InfoFigther(
                "Volkanovski",
                R.drawable.volkanovski,
                "69Kg",
                "Campeon del mundo en peso pluma",
                "d",
                "MMA"
            ),
            InfoFigther(
                "Sean O'Malley",
                R.drawable.sean,
                "61Kg",
                "Campeon del mundo en peso gallo",
                "d",
                "MMA"
            ),
            InfoFigther(
                "Tawanchai P.K.",
                R.drawable.tawanchai,
                "126Kg",
                "Campeon del mundo en peso pluma",
                "d",
                "MuayThai"
            ),
            InfoFigther(
                "Jonathan Haggerty",
                R.drawable.jonathan,
                "85Kg",
                "Campeon del mundo en peso gallo",
                "d",
                "MuayThai"
            ),
            InfoFigther(
                "Rodtang",
                R.drawable.rodtang,
                "66,5Kg",
                "Campeon del mundo en peso mosca",
                "d",
                "MuayThai"
            ),
            InfoFigther(
                "Joseph Lasiri",
                R.drawable.joseph,
                "61,2Kg",
                "Campeon del mundo en peso paja",
                "d",
                "MuayThai"
            ),
            InfoFigther(
                "Tyson Fury",
                R.drawable.tyson,
                "126Kg",
                "Campeon del mundo en peso completo",
                "d",
                "Boxeo"
            ),
            InfoFigther(
                "Canelo Álvarez",
                R.drawable.caneloalvarez,
                "85Kg",
                "Campeon del mundo en peso medio",
                "d",
                "Boxeo"
            ),
            InfoFigther(
                "Terence Crawford",
                R.drawable.terence,
                "66,5Kg",
                "Campeon del mundo en peso wélter",
                "s",
                "Boxeo"
            ),
            InfoFigther(
                "Devin Haney",
                R.drawable.devin,
                "61,2Kg",
                "Campeon del mundo en peso ligero",
                "d",
                "Boxeo"
            )
        )
}