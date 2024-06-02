package com.example.workoutapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "treino")
data class Treino(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val descricao: String,
    val data: Long // Timestamp
)
