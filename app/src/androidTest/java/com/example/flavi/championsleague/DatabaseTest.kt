package com.example.flavi.championsleague

import android.app.Application
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.flavi.dao.PaisDao
import com.example.flavi.database.ChampionsDatabase
import com.example.flavi.domain.Pais
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var paisDao: PaisDao
    private lateinit var db: ChampionsDatabase

    @Before
    fun createDb() {
        val appContext = InstrumentationRegistry.getTargetContext();
        db = Room.inMemoryDatabaseBuilder(appContext, ChampionsDatabase::class.java).build()
        paisDao = db.paisDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun testePais() {
        val pais: Pais = Pais("BRA", "Brasil");
        paisDao.insertAll(pais)

        val porNome = paisDao.findByName("Brasil")
//        Assert.assertEquals(porNome.nome, pais)
    }
}