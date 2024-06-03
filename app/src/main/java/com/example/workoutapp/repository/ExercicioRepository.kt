package com.example.workoutapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.workoutapp.model.Exercicio

class ExercicioRepository {

    private val exercicios = mutableListOf<Exercicio>()
    private val exerciciosLiveData = MutableLiveData<List<Exercicio>>(exercicios)

    fun getExerciciosByTreinoId(treinoId: Int): LiveData<List<Exercicio>> {
        val filteredExercicios = exercicios.filter { it.treinoId == treinoId }
        val liveData = MutableLiveData<List<Exercicio>>()
        liveData.value = filteredExercicios
        return liveData
    }

    fun getAllExercicios(): LiveData<List<Exercicio>> {
        return exerciciosLiveData
    }

    fun getExercicioById(id: String): LiveData<Exercicio?> {
        val exercicio = exercicios.find { it.id == id }
        val exercicioLiveData = MutableLiveData<Exercicio?>()
        exercicioLiveData.value = exercicio
        return exercicioLiveData
    }

    fun insertExercicio(exercicio: Exercicio) {
        exercicios.add(exercicio)
        exerciciosLiveData.value = exercicios
    }

    fun updateExercicio(exercicio: Exercicio) {
        val index = exercicios.indexOfFirst { it.id == exercicio.id }
        if (index != -1) {
            exercicios[index] = exercicio
            exerciciosLiveData.value = exercicios
        }
    }

    fun deleteExercicio(exercicio: Exercicio) {
        exercicios.remove(exercicio)
        exerciciosLiveData.value = exercicios
    }
}
