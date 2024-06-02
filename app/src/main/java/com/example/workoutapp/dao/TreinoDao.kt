package com.example.workoutapp.dao

import androidx.room.*
import com.example.workoutapp.model.Treino

@Dao
interface TreinoDao {
    @Insert
    suspend fun insertTreino(treino: Treino): Long

    @Query("SELECT * FROM treino")
    suspend fun getAllTreinos(): List<Treino>

    @Update
    suspend fun updateTreino(treino: Treino)

    @Delete
    suspend fun deleteTreino(treino: Treino)
}
