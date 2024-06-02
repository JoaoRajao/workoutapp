package com.example.workoutapp.dao

import androidx.room.*
import com.example.workoutapp.model.Exercicio

@Dao
interface ExercicioDao {
    @Insert
    suspend fun insertExercicio(exercicio: Exercicio): Long

    @Query("SELECT * FROM exercicio WHERE treinoId = :treinoId")
    suspend fun getExerciciosByTreinoId(treinoId: Int): List<Exercicio>

    @Update
    suspend fun updateExercicio(exercicio: Exercicio)

    @Delete
    suspend fun deleteExercicio(exercicio: Exercicio)
}
