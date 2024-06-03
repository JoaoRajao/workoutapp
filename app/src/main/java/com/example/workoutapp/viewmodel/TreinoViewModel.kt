package com.example.workoutapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.workoutapp.data.TreinoRepository
import com.example.workoutapp.model.Treino
import kotlinx.coroutines.launch

class TreinoViewModel(private val treinoRepository: TreinoRepository) : ViewModel() {

    val allTreinos: LiveData<List<Treino>> = treinoRepository.getAllTreinos()

    fun getTreinoById(id: Int): LiveData<Treino?> {
        return treinoRepository.getTreinoById(id)
    }

    fun insertTreino(treino: Treino) {
        viewModelScope.launch {
            treinoRepository.insertTreino(treino)
        }
    }

    fun updateTreino(treino: Treino) {
        viewModelScope.launch {
            treinoRepository.updateTreino(treino)
        }
    }

    fun deleteTreino(treino: Treino) {
        viewModelScope.launch {
            treinoRepository.deleteTreino(treino)
        }
    }
}

class TreinoViewModelFactory(private val treinoRepository: TreinoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TreinoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreinoViewModel(treinoRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
