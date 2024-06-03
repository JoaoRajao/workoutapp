package com.example.workoutapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemExercicioBinding
import com.example.workoutapp.model.Exercicio

class ExercicioAdapter(private val exercicios: List<Exercicio>) : RecyclerView.Adapter<ExercicioAdapter.ExercicioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioViewHolder {
        val binding = ItemExercicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExercicioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExercicioViewHolder, position: Int) {
        val exercicio = exercicios[position]
        holder.bind(exercicio)
    }

    override fun getItemCount(): Int = exercicios.size

    class ExercicioViewHolder(private val binding: ItemExercicioBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exercicio: Exercicio) {
            binding.textViewNome.text = exercicio.nome
            binding.textViewObservacoes.text = exercicio.observacoes
        }
    }
}
