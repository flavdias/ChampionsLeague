package com.example.flavi.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grupo(@PrimaryKey val nome: String) {
    @ColumnInfo
    var time1: String? = null

    @ColumnInfo
    var time2: String? = null

    @ColumnInfo
    var time3: String? = null

    @ColumnInfo
    var time4: String? = null

    override fun toString(): String {
        return "$nome: $time1, $time2, $time3, $time4"
    }


}
