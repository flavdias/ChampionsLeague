package com.example.flavi.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.flavi.domain.Grupo
import com.example.flavi.domain.Pais

@Dao
interface PaisDao {
    @Query("SELECT * FROM pais ORDER BY nome")
    fun getAll(): LiveData<List<Pais>>

    @Query("SELECT * FROM pais WHERE sigla IN (:siglas)")
    fun loadAllByIds(siglas: Array<String>): LiveData<List<Pais>>

    @Query("SELECT * FROM pais WHERE nome LIKE :nome LIMIT 1")
    fun findByName(nome: String): LiveData<Pais>

    @Insert
    fun insertAll(vararg users: Pais)

    @Delete
    fun delete(user: Pais)

    @Query("select p.* from pais p inner join time t on p.sigla = t.pais inner join grupo g on t.sigla in (g.time1, time2, time3, time4) where g.nome = :nome")
    fun findPaisInGrupo(nome: String): LiveData<List<Pais>>

}