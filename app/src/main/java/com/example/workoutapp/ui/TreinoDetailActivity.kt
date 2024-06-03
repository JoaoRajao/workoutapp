package com.example.workoutapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityTreinoDetailBinding
import com.example.workoutapp.viewmodel.ExercicioViewModel
import com.example.workoutapp.viewmodel.TreinoViewModel

class TreinoDetailActivity : AppCompatActivity() {

    private val treinoViewModel: TreinoViewModel by viewModels()
    private val exercicioViewModel: ExercicioViewModel by viewModels()
    private lateinit var binding: ActivityTreinoDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTreinoDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val treinoId = intent.getIntExtra("TREINO_ID", -1)
        if (treinoId != -1) {
            treinoViewModel.getTreinoById(treinoId).observe(this, Observer { treino ->
                treino?.let {
                    binding.treinoNome.text = it.nome
                    binding.treinoDescricao.text = it.descricao
                }
            })


        }

        binding.fabEditTreino.setOnClickListener {

        }

        binding.fabDeleteTreino.setOnClickListener {

        }
    }
}
