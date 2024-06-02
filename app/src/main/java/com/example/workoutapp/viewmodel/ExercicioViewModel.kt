package com.example.workoutapp.viewmodel

import androidx.lifecycle.*
import com.example.workoutapp.model.Exercicio
import com.example.workoutapp.repository.ExercicioRepository
import kotlinx.coroutines.launch

class ExercicioViewModel(private val repository: ExercicioRepository) : ViewModel() {
    fun getExerciciosByTreinoId(treinoId: Int): LiveData<List<Exercicio>> = liveData {
        emit(repository.getExerciciosByTreinoId(treinoId))
    }

    fun insertExercicio(exercicio: Exercicio) = viewModelScope.launch {
        repository.insertExercicio(exercicio)
    }

    fun updateExercicio(exercicio: Exercicio) = viewModelScope.launch {
        repository.updateExercicio(exercicio)
    }

    fun deleteExercicio(exercicio: Exercicio) = viewModelScope.launch {
        repository.deleteExercicio(exercicio)
    }
}
