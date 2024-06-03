package com.example.workoutapp.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.databinding.ActivityExercicioFormBinding
import com.example.workoutapp.model.Exercicio
import com.example.workoutapp.viewmodel.ExercicioViewModel
import com.example.workoutapp.viewmodel.ExercicioViewModelFactory
import com.example.workoutapp.data.ExercicioRepository

class ExercicioFormActivity : AppCompatActivity() {

    private val exercicioViewModel: ExercicioViewModel by viewModels {
        ExercicioViewModelFactory(ExercicioRepository())
    }
    private lateinit var binding: ActivityExercicioFormBinding

    private var exercicioId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExercicioFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exercicioId = intent.getStringExtra("EXERCICIO_ID")
        exercicioId?.let {
            exercicioViewModel.getExercicioById(it).observe(this, { exercicio ->
                exercicio?.let { populateForm(it) }
            })
        }

        binding.buttonSave.setOnClickListener {
            saveExercicio()
        }
    }

    private fun populateForm(exercicio: Exercicio) {
        binding.editTextNome.setText(exercicio.nome)
        binding.editTextObservacoes.setText(exercicio.observacoes)
    }

    private fun saveExercicio() {
        val nome = binding.editTextNome.text.toString()
        val observacoes = binding.editTextObservacoes.text.toString()

        if (nome.isEmpty()) {
            binding.editTextNome.error = "Nome é obrigatório"
            return
        }

        val exercicio = Exercicio(
            id = exercicioId ?: java.util.UUID.randomUUID().toString(),
            treinoId = intent.getIntExtra("TREINO_ID", -1),
            nome = nome,
            observacoes = observacoes,
            imagem = ""
        )

        if (exercicioId == null) {
            exercicioViewModel.insertExercicio(exercicio)
        } else {
            exercicioViewModel.updateExercicio(exercicio)
        }

        setResult(Activity.RESULT_OK)
        finish()
    }
}
