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
                "8fVHDV4ZAIs",
                "KickBoxing"
            ),
            InfoFigther(
                "Alex Pereira",
                R.drawable.alexpereira,
                "85Kg",
                "Campeon del mundo en peso medio",
                "bIyE_uM5EA8",
                "KickBoxing"
            ),
            InfoFigther(
                "Harut Grigorian",
                R.drawable.harutgrigorian,
                "77Kg",
                "Campeon del mundo en peso wélter",
                "3PmEIXWUlNc",
                "KickBoxing"
            ),
            InfoFigther(
                "Sitthichai",
                R.drawable.sitthichaisitsongpeenong,
                "70Kg",
                "Campeon del mundo en peso ligero",
                "DigtgHtJ6LA",
                "KickBoxing"
            ),
            InfoFigther(
                "Jon Jones",
                R.drawable.jonjones,
                "113g",
                "Campeon del mundo en pesado",
                "8lKirrARb0w",
                "MMA"
            ),
            InfoFigther(
                "Islam Makhachev",
                R.drawable.islam,
                "70Kg",
                "Campeon del mundo en peso ligero",
                "ypoI1m-M-0M",
                "MMA"
            ),
            InfoFigther(
                "Volkanovski",
                R.drawable.volkanovski,
                "69Kg",
                "Campeon del mundo en peso pluma",
                "cWq0JMxbPko",
                "MMA"
            ),
            InfoFigther(
                "Sean O'Malley",
                R.drawable.sean,
                "61Kg",
                "Campeon del mundo en peso gallo",
                "SQFv5lfJl8E",
                "MMA"
            ),
            InfoFigther(
                "Tawanchai P.K.",
                R.drawable.tawanchai,
                "126Kg",
                "Campeon del mundo en peso pluma",
                "Uzyi3qd_C3I",
                "MuayThai"
            ),
            InfoFigther(
                "Jonathan Haggerty",
                R.drawable.jonathan,
                "85Kg",
                "Campeon del mundo en peso gallo",
                "v_kKa3Rw51Q",
                "MuayThai"
            ),
            InfoFigther(
                "Rodtang",
                R.drawable.rodtang,
                "66,5Kg",
                "Campeon del mundo en peso mosca",
                "FxCqa3nb6XM",
                "MuayThai"
            ),
            InfoFigther(
                "Joseph Lasiri",
                R.drawable.joseph,
                "61,2Kg",
                "Campeon del mundo en peso paja",
                "3NRMdTWiraI",
                "MuayThai"
            ),
            InfoFigther(
                "Tyson Fury",
                R.drawable.tyson,
                "126Kg",
                "Campeon del mundo en peso completo",
                "3trHENldelY",
                "Boxeo"
            ),
            InfoFigther(
                "Canelo Álvarez",
                R.drawable.caneloalvarez,
                "85Kg",
                "Campeon del mundo en peso medio",
                "TrE91xJFAPM",
                "Boxeo"
            ),
            InfoFigther(
                "Terence Crawford",
                R.drawable.terence,
                "66,5Kg",
                "Campeon del mundo en peso wélter",
                "8cCw_xPuYow",
                "Boxeo"
            ),
            InfoFigther(
                "Devin Haney",
                R.drawable.devin,
                "61,2Kg",
                "Campeon del mundo en peso ligero",
                "S_HsSeRYspc",
                "Boxeo"
            )
        )
}