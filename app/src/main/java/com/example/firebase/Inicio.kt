package com.example.firebase

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

    class Inicio : AppCompatActivity() {

        private val authentication by lazy { FirebaseAuth.getInstance() }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val LogUser = findViewById<TextView>(R.id.LogUser)
            val btnlogout = findViewById<Button>(R.id.btnlogout)


            btnlogout.setOnClickListener {
                logout()
            }

            LogUser.text = authentication.currentUser?.email
        }

        private fun logout() {
            authentication.signOut()
            finish()
        }
    }
