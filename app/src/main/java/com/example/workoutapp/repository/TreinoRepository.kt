package com.example.workoutapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workoutapp.model.Treino

class TreinoRepository {

    private val treinos = mutableListOf<Treino>()
    private val treinosLiveData = MutableLiveData<List<Treino>>(treinos)

    fun getAllTreinos(): LiveData<List<Treino>> {
        return treinosLiveData
    }

    fun getTreinoById(id: Int): LiveData<Treino?> {
        val treino = treinos.find { it.id == id }
        val treinoLiveData = MutableLiveData<Treino?>()
        treinoLiveData.value = treino
        return treinoLiveData
    }

    fun insertTreino(treino: Treino) {
        treinos.add(treino)
        treinosLiveData.value = treinos
    }

    fun updateTreino(treino: Treino) {
        val index = treinos.indexOfFirst { it.id == treino.id }
        if (index != -1) {
            treinos[index] = treino
            treinosLiveData.value = treinos
        }
    }

    fun deleteTreino(treino: Treino) {
        treinos.remove(treino)
        treinosLiveData.value = treinos
    }
}
