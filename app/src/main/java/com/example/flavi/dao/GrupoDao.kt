package com.example.flavi.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flavi.domain.Grupo
import com.example.flavi.domain.Pais

@Dao
interface GrupoDao {
    @Query("SELECT * FROM grupo")
    fun getAll(): List<Grupo>

    @Query("SELECT * FROM grupo WHERE nome IN (:nomes)")
    fun loadAllByIds(nomes: Array<String>): List<Grupo>

    @Query("SELECT * FROM grupo WHERE nome LIKE :nome LIMIT 1")
    fun findByName(nome: String): Grupo

    @Insert
    fun insertAll(vararg grupos: Grupo)

    @Delete
    fun delete(grupo: Grupo)
}