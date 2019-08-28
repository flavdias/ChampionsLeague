package com.example.flavi.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.flavi.dao.GrupoDao
import com.example.flavi.dao.PaisDao
import com.example.flavi.dao.TimeDao
import com.example.flavi.domain.Grupo
import com.example.flavi.domain.Pais
import com.example.flavi.domain.Time
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Pais::class, Time::class, Grupo::class], version = 1, exportSchema = false)
public abstract class ChampionsDatabase: RoomDatabase() {
    abstract fun paisDao(): PaisDao
    abstract fun timeDao(): TimeDao
    abstract fun grupoDao(): GrupoDao

    companion object {
        @Volatile
        private var INSTANCE: ChampionsDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ChampionsDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ChampionsDatabase::class.java,
                        "champions_database"
                ).
                        allowMainThreadQueries().
                        addCallback(ChampionsDatabaseCallback(scope)).
                        build()
                INSTANCE = instance
                return instance
            }
        }

        private class ChampionsDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.paisDao())
                    }
                }
            }
        }

        fun populateDatabase(paisDao: PaisDao) {
            paisDao.deleteAll()

            var pais = Pais("BRA", "Brasil")
            paisDao.insertAll(pais)
        }
    }
}