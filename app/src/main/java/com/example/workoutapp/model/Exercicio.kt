package com.example.workoutapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercicio")
data class Exercicio(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val treinoId: Int,
    val nome: String,
    val imagem: String, // URL ou URI
    val observacoes: String
)
