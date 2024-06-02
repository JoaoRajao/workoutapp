package com.example.workoutapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.R
import com.example.workoutapp.model.Exercicio
import com.example.workoutapp.viewmodel.ExercicioViewModel
import kotlinx.android.synthetic.main.activity_exercicio_form.*

class ExercicioFormActivity : AppCompatActivity() {

    private val exercicioViewModel: ExercicioViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercicio_form)

        val treinoId = intent.getIntExtra("TREINO_ID", -1)
        val exercicioId = intent.getIntExtra("EXERCICIO_ID", -1)

        if (exercicioId != -1) {
            exercicioViewModel.getExercicioById(exercicioId).observe(this, Observer { exercicio ->
                exercicio?.let {
                    editText_nome.setText(it.nome)
                    editText_observacoes.setText(it.observacoes)
                    // Carregar imagem
                }
            })
        }

        button_save.setOnClickListener {
            val nome = editText_nome.text.toString()
            val observacoes = editText_observacoes.text.toString()
            val imagem = "URL ou URI da imagem" // Pegar da ImageView

            if (exercicioId == -1) {
                val novoExercicio = Exercicio(treinoId = treinoId, nome = nome, imagem = imagem, observacoes = observacoes)
                exercicioViewModel.insertExercicio(novoExercicio)
            } else {
                val exercicioAtualizado = Exercicio(id = exercicioId, treinoId = treinoId, nome = nome, imagem = imagem, observacoes = observacoes)
                exercicioViewModel.updateExercicio(exercicioAtualizado)
            }
            finish()
        }
    }
}
