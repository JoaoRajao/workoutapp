package com.example.workoutapp.model

data class Exercicio(
    val id: String,
    val treinoId: Int,
    val nome: String,
    val observacoes: String,
    val imagem: String
)
