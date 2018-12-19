package com.example.flavi.domain

data class Time(val sigla: String, val nome: String, val icone: String, val pais: String, val pote: Int) {
    override fun toString(): String {
        return "$nome"
    }
}