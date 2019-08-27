package com.example.flavi.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = arrayOf(Index(value = ["sigla"])))
data class Pais(@PrimaryKey val sigla: String,
                @ColumnInfo val nome: String) {
    override fun toString(): String {
        return "$sigla - $nome"
    }
}