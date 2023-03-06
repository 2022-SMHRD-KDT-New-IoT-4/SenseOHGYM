package com.example.senseohgym_h

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.toolbox.Volley
import com.example.senseohgym_h.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val requestQueue = Volley.newRequestQueue(this)
        val btnJoin = findViewById<Button>(R.id.btnJoin)
        val etPw = findViewById<EditText>(R.id.etPw)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etId = findViewById<EditText>(R.id.etId)


        btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            var id = etId.text.toString()
            var pw = etPw.text.toString()

            val nextIntent = Intent(this, MainActivity::class.java)
            nextIntent.putExtra("id", id)
            nextIntent.putExtra("pw", pw)

            startActivity(nextIntent)

        }}}





