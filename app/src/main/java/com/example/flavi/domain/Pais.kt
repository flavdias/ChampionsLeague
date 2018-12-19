package com.example.flavi.domain

data class Pais(val nome: String, val sigla: String) {
    override fun toString(): String {
        return "$sigla - $nome"
    }
}