package com.example.flavi.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flavi.domain.Time

@Dao
interface TimeDao {
    @Query("SELECT * FROM time")
    fun getAll(): List<Time>

    @Query("SELECT * FROM time WHERE sigla IN (:siglas)")
    fun loadAllByIds(siglas: Array<String>): List<Time>

    @Query("SELECT * FROM time WHERE nome LIKE :nome LIMIT 1")
    fun findByName(nome: String): Time

    @Insert
    fun insertAll(vararg users: Time)

    @Delete
    fun delete(user: Time)
}