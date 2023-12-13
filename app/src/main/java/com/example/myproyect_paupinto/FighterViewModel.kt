package com.example.myproyect_paupinto

import androidx.lifecycle.ViewModel

class FighterViewModel: ViewModel(){

    var nameFighter = ""
    var urlFighter = ""
    var grupoFighter = ""

    fun setName(name: String){
        nameFighter = name
    }

    fun setUrl(url: String){
        urlFighter = url
    }

    fun setGrupo(grupo: String) {
        grupoFighter = grupo
    }
}

