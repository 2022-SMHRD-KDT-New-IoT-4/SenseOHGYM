package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etName = findViewById<EditText>(R.id.etName)
        val etGymName = findViewById<EditText>(R.id.etGymName)
        val etCard = findViewById<EditText>(R.id.etCard)

        btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            var name = etName.text.toString()
            var gymName = etGymName.text.toString()
            var card = etCard.text.toString()

            intent.putExtra("name", name)
            intent.putExtra("gymName", gymName)
            intent.putExtra("card", card)

            startActivity(intent)
        }


    }
}