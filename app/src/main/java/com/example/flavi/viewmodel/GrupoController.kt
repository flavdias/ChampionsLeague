package com.example.flavi.viewmodel

import android.content.Context
import com.example.flavi.dao.GrupoDao
import com.example.flavi.domain.Grupo
import com.example.flavi.domain.Pais
import com.example.flavi.domain.Time

class GrupoController {
    private lateinit var context: Context
    private lateinit var grupoDao: GrupoDao


    constructor(context: Context) {
        this.context = context

    }

    fun getPaises(grupo: Grupo?): List<Pais>? {
        var paises: MutableList<Pais> = mutableListOf();

        val nomesTimes : List<String?> = listOf(grupo?.time1, grupo?.time2, grupo?.time3, grupo?.time4)
        val times: List<Time> =
//        for (i in nomesTimes) {
//
//        }
//    fun getPaises(): List<String> {
//        var paises : MutableList<String> = mutableListOf<String>()
//
//        for (i in times.indices){
//            val time = times[i]
//
//            time?.let {
//                paises.add(time.pais)
//            }
//        }
//
//        return paises
//    }

        return null
    }

    fun addTime(grupo: Grupo, time: Time): Grupo {
        return grupo
    }
}