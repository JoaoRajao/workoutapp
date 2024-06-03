package com.example.workoutapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.databinding.ActivityTreinoListBinding
import com.example.workoutapp.viewmodel.TreinoViewModel

class TreinoListActivity : AppCompatActivity() {

    private val treinoViewModel: TreinoViewModel by viewModels()
    private lateinit var binding: ActivityTreinoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTreinoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = TreinoListAdapter(emptyList()) { treino ->
            val intent = Intent(this, TreinoDetailActivity::class.java)
            intent.putExtra("TREINO_ID", treino.id)
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        treinoViewModel.allTreinos.observe(this, Observer { treinos ->
            treinos?.let { adapter.updateTreinos(it) }
        })

        binding.fab.setOnClickListener {
            val intent = Intent(this, TreinoFormActivity::class.java)
            startActivity(intent)
        }
    }
}
