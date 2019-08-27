package com.example.flavi.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.flavi.dao.PaisDao
import com.example.flavi.domain.Pais

class PaisRepository(private val paisDao: PaisDao) {
    val todosPaises: LiveData<List<Pais>> = paisDao.getAll()

    @WorkerThread
    suspend fun insert(pais: Pais) {
        paisDao.insertAll(pais)
    }
}