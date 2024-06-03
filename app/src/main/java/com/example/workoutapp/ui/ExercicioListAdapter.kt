package com.example.workoutapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemExercicioBinding
import com.example.workoutapp.model.Exercicio

class ExercicioListAdapter : RecyclerView.Adapter<ExercicioListAdapter.ExercicioViewHolder>() {

    private var exercicios: List<Exercicio> = emptyList()

    inner class ExercicioViewHolder(val binding: ItemExercicioBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioViewHolder {
        val binding = ItemExercicioBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExercicioViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExercicioViewHolder, position: Int) {
        val exercicio = exercicios[position]
        holder.binding.textViewNome.text = exercicio.nome
        holder.binding.textViewObservacoes.text = exercicio.observacoes
    }

    override fun getItemCount() = exercicios.size

    fun submitList(newExercicios: List<Exercicio>) {
        this.exercicios = newExercicios
        notifyDataSetChanged()
    }
}
