package com.example.workoutapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.workoutapp.data.ExercicioRepository
import com.example.workoutapp.model.Exercicio
import kotlinx.coroutines.launch

class ExercicioViewModel(private val exercicioRepository: ExercicioRepository) : ViewModel() {

    val allExercicios: LiveData<List<Exercicio>> = exercicioRepository.getAllExercicios()

    fun getExercicioById(id: String): LiveData<Exercicio?> {
        return exercicioRepository.getExercicioById(id)
    }

    fun insertExercicio(exercicio: Exercicio) {
        viewModelScope.launch {
            exercicioRepository.insertExercicio(exercicio)
        }
    }

    fun updateExercicio(exercicio: Exercicio) {
        viewModelScope.launch {
            exercicioRepository.updateExercicio(exercicio)
        }
    }

    fun deleteExercicio(exercicio: Exercicio) {
        viewModelScope.launch {
            exercicioRepository.deleteExercicio(exercicio)
        }
    }
}

class ExercicioViewModelFactory(private val exercicioRepository: ExercicioRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExercicioViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExercicioViewModel(exercicioRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
