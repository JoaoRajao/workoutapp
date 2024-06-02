package com.example.workoutapp.repository

import com.example.workoutapp.dao.TreinoDao
import com.example.workoutapp.model.Treino

class TreinoRepository(private val treinoDao: TreinoDao) {
    suspend fun insertTreino(treino: Treino) = treinoDao.insertTreino(treino)
    suspend fun getAllTreinos() = treinoDao.getAllTreinos()
    suspend fun updateTreino(treino: Treino) = treinoDao.updateTreino(treino)
    suspend fun deleteTreino(treino: Treino) = treinoDao.deleteTreino(treino)
}
