package com.example.flavi.championsleague

import com.beust.klaxon.Klaxon
import com.example.flavi.domain.Pais
import com.example.flavi.domain.Time
import org.junit.Test

import org.junit.Assert.*
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testCarga() {
        val arquivoCarga = File(Sorteio.CARGA_PAISES)
        println(arquivoCarga.absolutePath)

        data class Paises(val paises: MutableList<Pais>)
        val result = Klaxon().parse<Paises>(arquivoCarga)

        println(result)

        val arquivoCargaTimes = File(Sorteio.CARGA_TIMES)
        println(arquivoCargaTimes.absolutePath)

        data class Times(val times: MutableList<Time>)
        val resultTimes = Klaxon().parse<Times>(arquivoCargaTimes)

        println(resultTimes)
    }

    @Test
    fun testSorteio() {
        val sorteio = Sorteio()
        sorteio.executaSorteio()
    }

}
