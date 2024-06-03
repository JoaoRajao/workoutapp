package com.example.workoutapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemTreinoBinding
import com.example.workoutapp.model.Treino

class TreinoListAdapter(
    private var treinos: List<Treino>,
    private val onItemClick: (Treino) -> Unit
) : RecyclerView.Adapter<TreinoListAdapter.TreinoViewHolder>() {

    inner class TreinoViewHolder(val binding: ItemTreinoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreinoViewHolder {
        val binding = ItemTreinoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TreinoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TreinoViewHolder, position: Int) {
        val treino = treinos[position]
        holder.binding.textViewNome.text = treino.nome
        holder.binding.textViewDescricao.text = treino.descricao

        holder.itemView.setOnClickListener {
            onItemClick(treino)
        }
    }

    override fun getItemCount() = treinos.size

    fun updateTreinos(newTreinos: List<Treino>) {
        this.treinos = newTreinos
        notifyDataSetChanged()
    }
}
