package com.example.workoutapp.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.databinding.ActivityTreinoFormBinding
import com.example.workoutapp.model.Treino
import com.example.workoutapp.viewmodel.TreinoViewModel
import com.example.workoutapp.viewmodel.TreinoViewModelFactory
import com.example.workoutapp.data.TreinoRepository
import com.google.android.material.snackbar.Snackbar

class TreinoFormActivity : AppCompatActivity() {

    private val treinoViewModel: TreinoViewModel by viewModels {
        TreinoViewModelFactory(TreinoRepository())
    }
    private lateinit var binding: ActivityTreinoFormBinding

    private var treinoId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTreinoFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        treinoId = intent.getIntExtra("TREINO_ID", -1)
        Log.d("TreinoFormActivity", "Received Treino ID: $treinoId")

        if (treinoId != -1) {
            treinoId?.let {
                treinoViewModel.getTreinoById(it).observe(this, { treino ->
                    treino?.let {
                        Log.d("TreinoFormActivity", "Populating form with Treino: $it")
                        binding.editTextNome.setText(it.nome)
                        binding.editTextDescricao.setText(it.descricao)
                    }
                })
            }
        }

        binding.buttonSave.setOnClickListener {
            saveTreino()
        }
    }

    private fun saveTreino() {
        val nome = binding.editTextNome.text.toString()
        val descricao = binding.editTextDescricao.text.toString()

        Log.d("TreinoFormActivity", "Saving Treino with nome: $nome, descricao: $descricao")

        if (nome.isEmpty()) {
            binding.editTextNome.error = "Nome é obrigatório"
            Log.e("TreinoFormActivity", "Nome is empty")
            return
        }

        try {
            val treino = Treino(
                id = treinoId ?: 0,
                nome = nome,
                descricao = descricao,
                data = System.currentTimeMillis()
            )

            Log.d("TreinoFormActivity", "Treino to be saved: $treino")

            if (treinoId == null || treinoId == 0) {
                treinoViewModel.insertTreino(treino)
            } else {
                treinoViewModel.updateTreino(treino)
            }

            setResult(RESULT_OK)
            finish()
        } catch (e: Exception) {
            Log.e("TreinoFormActivity", "Error saving treino: ${e.message}", e)
            showSnackbar("Error saving treino: ${e.message}")
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}
