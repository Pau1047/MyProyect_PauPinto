package com.example.myproyect_paupinto

data class InfoFighter(
    val name: String,
    val imagen: Int,
    val peso: String,
    val titulos: String,
    val url: String,
    val grupo: String
)

fun getInfoFighter(): List<InfoFighter>{

        return listOf(
            InfoFighter(
                "Artem Vakhitov",
                R.drawable.artem,
                " ‣ 95Kg",
                " ‣ Campeon del mundo en peso semipesado",
                "8fVHDV4ZAIs",
                "KickBoxing"
            ),
            InfoFighter(
                "Alex Pereira",
                R.drawable.alexpereira,
                " ‣ 85Kg",
                " ‣ Campeon del mundo en peso medio",
                "bIyE_uM5EA8",
                "KickBoxing"
            ),
            InfoFighter(
                "Harut Grigorian",
                R.drawable.harutgrigorian,
                " ‣ 77Kg",
                " ‣ Campeon del mundo en peso wélter",
                "3PmEIXWUlNc",
                "KickBoxing"
            ),
            InfoFighter(
                "Sitthichai",
                R.drawable.sitthichaisitsongpeenong,
                " ‣ 70Kg",
                " ‣ Campeon del mundo en peso ligero",
                "DigtgHtJ6LA",
                "KickBoxing"
            ),
            InfoFighter(
                "Jon Jones",
                R.drawable.jonjones,
                " ‣ 113Kg",
                " ‣ Campeon del mundo en pesado",
                "8lKirrARb0w",
                "MMA"
            ),
            InfoFighter(
                "Islam",
                R.drawable.islam,
                " ‣ 70Kg",
                " ‣ Campeon del mundo en peso ligero",
                "ypoI1m-M-0M",
                "MMA"
            ),
            InfoFighter(
                "Volkanovski",
                R.drawable.volkanovski,
                " ‣ 69Kg",
                " ‣ Campeon del mundo en peso pluma",
                "cWq0JMxbPko",
                "MMA"
            ),
            InfoFighter(
                "Sean O'Malley",
                R.drawable.sean,
                " ‣ 61Kg",
                " ‣ Campeon del mundo en peso gallo",
                "SQFv5lfJl8E",
                "MMA"
            ),
            InfoFighter(
                "Tawanchai P.K.",
                R.drawable.tawanchai,
                " ‣ 70Kg",
                " ‣ Campeon del mundo en peso pluma",
                "Uzyi3qd_C3I",
                "MuayThai"
            ),
            InfoFighter(
                "Jonathan",
                R.drawable.jonathan,
                " ‣ 85Kg",
                " ‣ Campeon del mundo en peso gallo",
                "v_kKa3Rw51Q",
                "MuayThai"
            ),
            InfoFighter(
                "Rodtang",
                R.drawable.rodtang,
                " ‣ 66,5Kg",
                " ‣ Campeon del mundo en peso mosca",
                "FxCqa3nb6XM",
                "MuayThai"
            ),
            InfoFighter(
                "Joseph Lasiri",
                R.drawable.joseph,
                " ‣ 61,2Kg",
                " ‣ Campeon del mundo en peso paja",
                "3NRMdTWiraI",
                "MuayThai"
            ),
            InfoFighter(
                "Tyson Fury",
                R.drawable.tyson,
                " ‣ 126Kg",
                " ‣ Campeon del mundo en peso completo",
                "3trHENldelY",
                "Boxeo"
            ),
            InfoFighter(
                "Canelo Álvarez",
                R.drawable.caneloalvarez,
                " ‣ 85Kg",
                " ‣ Campeon del mundo en peso medio",
                "TrE91xJFAPM",
                "Boxeo"
            ),
            InfoFighter(
                "Crawford",
                R.drawable.terence,
                " ‣ 66,5Kg",
                " ‣ Campeon del mundo en peso wélter",
                "8cCw_xPuYow",
                "Boxeo"
            ),
            InfoFighter(
                "Devin Haney",
                R.drawable.devin,
                " ‣ 61,2Kg",
                " ‣ Campeon del mundo en peso ligero",
                "S_HsSeRYspc",
                "Boxeo"
            )
        )
}