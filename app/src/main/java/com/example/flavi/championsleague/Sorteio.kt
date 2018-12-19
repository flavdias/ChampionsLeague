package com.example.flavi.championsleague

import com.beust.klaxon.Klaxon
import com.example.flavi.domain.Grupo
import com.example.flavi.domain.Time
import java.io.File
import java.util.*

class Sorteio {

    companion object {
        private const val PATH = "src/main/assets/"
        val NOMES_GRUPOS = arrayOf("GRUPO A",
                "GRUPO B",
                "GRUPO C",
                "GRUPO D",
                "GRUPO E",
                "GRUPO F",
                "GRUPO G",
                "GRUPO H")
        const val CARGA_TIMES = "$PATH/times.json"
        const val CARGA_PAISES = "$PATH/paises.json"
    }

    var grupos = arrayOfNulls<Grupo>(8)
    var times = mutableListOf<Time>()

    constructor() {
        criaGrupos()
        criaTimes()
    }

    fun executaSorteio() {
        for (i in grupos.indices)
            print(grupos[i])
        println()

        println(times)

        for (i in 1 until 4) {
            sorteiaTimesPote(i)
        }

        for (i in grupos.indices)
            print(grupos[i])
        println()

    }

    fun sorteiaTimesPote(pote: Int) {
        for (i in grupos.indices) {
            val timesPote = selecionaTimes(pote)
            var paisesAdicionados: List<String>? = null

            if (i != 1)
                paisesAdicionados = grupos[i]?.getPaises()

            val timeAux = sorteiaTime(timesPote, paisesAdicionados)

            grupos[i]?.addGrupo(timeAux)
            times.remove(timeAux)
        }
    }

    fun selecionaTimes(pote: Int): List<Time> {
        return times.filter { time -> time.pote == pote }
    }

    fun sorteiaTime(times: List<Time>, paises: List<String>?): Time {
        var randomTime: Time? = null

        while (randomTime == null) {
            randomTime = times.get(Random().nextInt(times.size))

            if (paises != null && paises.contains(randomTime.pais)) {
                randomTime = null
            }
        }

        return randomTime
    }

    fun criaGrupos() {
        for (i in grupos.indices) {
            grupos[i] = Grupo(NOMES_GRUPOS[i])
        }
    }

    fun criaTimes() {
        val cargaTimes = File(CARGA_TIMES)

        if (!cargaTimes.isFile) {
            println("Arquivo não encontrado")
            return
        }

        data class Times(val times: MutableList<Time>)
        val timeCarga = Klaxon().parse<Times>(cargaTimes)

        if (timeCarga == null) {
            println("Carga inválida")
            return
        }

        times = timeCarga.times.toMutableList()
    }
}