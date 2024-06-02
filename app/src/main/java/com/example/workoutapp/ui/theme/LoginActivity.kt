package com.example.workoutapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        button_login.setOnClickListener {
            val email = editText_email.text.toString()
            val password = editText_password.text.toString()
            loginUser(email, password)
        }

        button_register.setOnClickListener {
            val email = editText_email.text.toString()
            val password = editText_password.text.toString()
            registerUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Redirecionar para a lista de treinos
            } else {
                // Mostrar mensagem de erro
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Redirecionar para a lista de treinos
            } else {
                // Mostrar mensagem de erro
            }
        }
    }
}
