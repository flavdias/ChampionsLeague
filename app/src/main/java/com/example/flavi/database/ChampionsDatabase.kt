package com.example.flavi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flavi.dao.GrupoDao
import com.example.flavi.dao.PaisDao
import com.example.flavi.dao.TimeDao
import com.example.flavi.domain.Grupo
import com.example.flavi.domain.Pais
import com.example.flavi.domain.Time

@Database(entities = [Pais::class, Time::class, Grupo::class], version = 1, exportSchema = false)
public abstract class ChampionsDatabase: RoomDatabase() {
    abstract fun paisDao(): PaisDao
    abstract fun timeDao(): TimeDao
    abstract fun grupoDao(): GrupoDao

    companion object {
        @Volatile
        private var INSTANCE: ChampionsDatabase? = null

        fun getDatabase(context: Context): ChampionsDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ChampionsDatabase::class.java,
                        "champions_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}