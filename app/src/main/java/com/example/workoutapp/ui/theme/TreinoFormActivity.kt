package com.example.workoutapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.R
import com.example.workoutapp.model.Treino
import com.example.workoutapp.viewmodel.TreinoViewModel
import kotlinx.android.synthetic.main.activity_treino_form.*

class TreinoFormActivity : AppCompatActivity() {

    private val treinoViewModel: TreinoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_form)

        val treinoId = intent.getIntExtra("TREINO_ID", -1)

        if (treinoId != -1) {
            treinoViewModel.getTreinoById(treinoId).observe(this, Observer { treino ->
                treino?.let {
                    editText_nome.setText(it.nome)
                    editText_descricao.setText(it.descricao)
                }
            })
        }

        button_save.setOnClickListener {
            val nome = editText_nome.text.toString()
            val descricao = editText_descricao.text.toString()

            if (treinoId == -1) {
                val novoTreino = Treino(nome = nome, descricao = descricao, data = System.currentTimeMillis())
                treinoViewModel.insertTreino(novoTreino)
            } else {
                val treinoAtualizado = Treino(id = treinoId, nome = nome, descricao = descricao, data = System.currentTimeMillis())
                treinoViewModel.updateTreino(treinoAtualizado)
            }
            finish()
        }
    }
}
