package com.example.workoutapp.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.liveData
import com.example.workoutapp.model.Treino
import com.example.workoutapp.repository.TreinoRepository
import kotlinx.coroutines.launch

class TreinoViewModel(private val repository: TreinoRepository) : ViewModel() {
    val allTreinos: LiveData<List<Treino>> = liveData {
        emit(repository.getAllTreinos())
    }

    fun insertTreino(treino: Treino) = viewModelScope.launch {
        repository.insertTreino(treino)
    }

    fun updateTreino(treino: Treino) = viewModelScope.launch {
        repository.updateTreino(treino)
    }

    fun deleteTreino(treino: Treino) = viewModelScope.launch {
        repository.deleteTreino(treino)
    }
}
