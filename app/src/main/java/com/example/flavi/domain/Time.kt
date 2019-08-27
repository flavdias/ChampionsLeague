package com.example.flavi.domain

import androidx.room.*

@Entity(indices = arrayOf(Index(value = ["sigla"])),
        foreignKeys = arrayOf(ForeignKey(
        entity = Pais::class,
        parentColumns = arrayOf("sigla"),
        childColumns = arrayOf("pais")
)))
data class Time(@PrimaryKey val sigla: String,
                @ColumnInfo val nome: String,
                @ColumnInfo val icone: String,
                @ColumnInfo val pais: String,
                @ColumnInfo val pote: Int?) {
    override fun toString(): String {
        return "$nome"
    }
}