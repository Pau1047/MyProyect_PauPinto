package com.example.myproyect_paupinto

import androidx.lifecycle.ViewModel

class FigtherViewModel: ViewModel(){

    var nameFigther = ""
    var urlFigther = ""
    var grupoFigther = ""

    fun setName(name: String){
        nameFigther = name
    }

    fun setUrl(url: String){
        urlFigther = url
    }

    fun setGrupo(grupo: String) {
        grupoFigther = grupo
    }
}

