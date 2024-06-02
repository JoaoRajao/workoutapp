package com.example.workoutapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workoutapp.R
import com.example.workoutapp.viewmodel.TreinoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_treino_list.*

class TreinoListActivity : AppCompatActivity() {

    private val treinoViewModel: TreinoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treino_list)

        val adapter = TreinoListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        treinoViewModel.allTreinos.observe(this, Observer { treinos ->
            treinos?.let { adapter.submitList(it) }
        })

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            val intent = Intent(this, TreinoFormActivity::class.java)
            startActivity(intent)
        }
    }
}
