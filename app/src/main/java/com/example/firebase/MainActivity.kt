package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private val autentication by lazy {
        FirebaseAuth.getInstance()
    }
    data class UserModelo(
        val
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etSenha = findViewById<EditText>(R.id.etSenha)
        val btlogin = findViewById<Button>(R.id.btlogin)
        val btcadastro = findViewById<Button>(R.id.btcadastro)

        if (etEmail.toString().isNullOrEmpty() || etSenha.toString().isNullOrEmpty()) {
        } else {

            data class UserModelo(val email: String, val senha: String)

        }
        btcadastro.setOnClickListener {

            var email = etEmail.text.toString()
            var senha = etSenha.text.toString()
            autentication.createUserWithEmailAndPassword(
                email, senha
            ).addOnSuccessListener {
                Toast.makeText(this, "cadastrado com sucesso!", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "erro ao efetuar o cadastro", Toast.LENGTH_LONG).show()
            }
        } else {
            cadastrar()
        }
        btlogin.setOnClickListener {

            var email = etEmail.text.toString()
            var senha = etSenha.text.toString()
            autentication.signInWithEmailAndPassword(
                email, senha
            ).addOnSuccessListener {
                var intent = Intent(this, Inicio::class.java).apply {
                    intent.putExtra("email", email)
                }
                startActivity(intent)
                Toast.makeText(this, "logado com sucesso!", Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(this, "erro ao efetuar o login", Toast.LENGTH_LONG).show()
            }
        }
    }

        override fun onStart() {
            super.onStart()
            verificarLogin()
        }

        private fun verificarLogin() {
            val user = autentication.currentUser
            if (user != null) {
                abrirInicio()
            }
        }
    }
