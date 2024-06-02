package com.example.workoutapp.repository

import com.example.workoutapp.dao.ExercicioDao
import com.example.workoutapp.model.Exercicio

class ExercicioRepository(private val exercicioDao: ExercicioDao) {
    suspend fun insertExercicio(exercicio: Exercicio) = exercicioDao.insertExercicio(exercicio)
    suspend fun getExerciciosByTreinoId(treinoId: Int) = exercicioDao.getExerciciosByTreinoId(treinoId)
    suspend fun updateExercicio(exercicio: Exercicio) = exercicioDao.updateExercicio(exercicio)
    suspend fun deleteExercicio(exercicio: Exercicio) = exercicioDao.deleteExercicio(exercicio)
}
