package com.example.myproyect_paupinto

import androidx.lifecycle.ViewModel

class FigtherViewModel: ViewModel(){

    var nameFigther = ""
    var urlFigther = ""
    var grupoFigther = ""

    fun setName(name: String, url: String){
        nameFigther = name
        urlFigther = url
    }

    fun setGrupo(grupo: String) {
        grupoFigther = grupo
    }
}

