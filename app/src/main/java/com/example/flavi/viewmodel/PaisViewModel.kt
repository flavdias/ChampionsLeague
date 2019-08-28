package com.example.flavi.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.flavi.database.ChampionsDatabase
import com.example.flavi.domain.Pais
import com.example.flavi.repository.PaisRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaisViewModel(application: Application): AndroidViewModel(application) {
    private val repository: PaisRepository
    val todosPaises: LiveData<List<Pais>>

    init {
        val paisDao = ChampionsDatabase.getDatabase(application, viewModelScope).paisDao()
        repository = PaisRepository(paisDao)
        todosPaises = repository.todosPaises
    }

    fun insert(pais: Pais) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(pais)
    }
}