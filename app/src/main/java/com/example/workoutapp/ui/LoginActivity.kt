package com.example.workoutapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.workoutapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (validateInput(email, password)) {
                loginUser(email, password)
            }
        }

        binding.buttonRegister.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (validateInput(email, password)) {
                registerUser(email, password)
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            email.isEmpty() -> {
                binding.editTextEmail.error = "Email é obrigatório"
                false
            }
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                binding.editTextEmail.error = "Formato de email inválido"
                false
            }
            password.isEmpty() -> {
                binding.editTextPassword.error = "Senha é obrigatória"
                false
            }
            password.length < 6 -> {
                binding.editTextPassword.error = "A senha deve ter pelo menos 6 caracteres"
                false
            }
            else -> true
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("LoginActivity", "Login bem-sucedido.")
                navigateToTreinoForm()
            } else {
                val errorMessage = task.exception?.message ?: "Erro desconhecido"
                Log.e("LoginActivity", "Erro no login: $errorMessage")
                showSnackbar(errorMessage)
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("LoginActivity", "Registro bem-sucedido.")
                navigateToTreinoForm()
            } else {
                val errorMessage = task.exception?.message ?: "Erro desconhecido"
                Log.e("LoginActivity", "Erro no registro: $errorMessage")
                showSnackbar(errorMessage)
            }
        }
    }

    private fun navigateToTreinoForm() {
        val intent = Intent(this, TreinoFormActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }
}
