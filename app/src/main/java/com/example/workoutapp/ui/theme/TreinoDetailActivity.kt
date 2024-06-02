package com.example.workoutapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.R
import com.example.workoutapp.viewmodel.TreinoViewModel
import kotlinx.android.synthetic.main.activity_treino_detail.*

class TreinoDetailActivity : AppCompatActivity() {

    private val treinoViewModel: TreinoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_detail)

        val treinoId = intent.getIntExtra("TREINO_ID", -1)

        if (treinoId != -1) {
            treinoViewModel.getTreinoById(treinoId).observe(this, Observer { treino ->
                treino?.let {
                    treino_nome.text = it.nome
                    treino_descricao.text = it.descricao
                }
            })

            val adapter = ExercicioListAdapter()
            recyclerView_exercicios.adapter = adapter
            recyclerView_exercicios.layoutManager = LinearLayoutManager(this)

            treinoViewModel.getExerciciosByTreinoId(treinoId).observe(this, Observer { exercicios ->
                exercicios?.let { adapter.submitList(it) }
            })

            fab_edit_treino.setOnClickListener {
                val intent = Intent(this, TreinoFormActivity::class.java)
                intent.putExtra("TREINO_ID", treinoId)
                startActivity(intent)
            }

            fab_delete_treino.setOnClickListener {
                treinoViewModel.deleteTreino(treinoId)
                finish()
            }
        }
    }
}
