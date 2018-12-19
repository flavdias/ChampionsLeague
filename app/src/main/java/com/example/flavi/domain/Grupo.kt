package com.example.flavi.domain

data class Grupo(val nome: String) {

    var times: Array<Time?> = arrayOfNulls<Time>(4)

    fun addGrupo(time: Time) {
        times[time.pote - 1] = time
    }

    fun getPaises(): List<String> {
        var paises : MutableList<String> = mutableListOf<String>()

        for (i in times.indices){
            val time = times[i]

            time?.let {
                paises.add(time.pais)
            }
        }

        return paises
    }

    override fun toString(): String {
        val time1 = times[0]?.nome ?: ""
        val time2 = times[1]?.nome ?: ""
        val time3 = times[2]?.nome ?: ""
        val time4 = times[3]?.nome ?: ""

        return "$nome: $time1, $time2, $time3, $time4"
    }


}
