package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Ex7Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex7)

        val btnExer07 = findViewById<ImageButton>(R.id.btnExer07)

        btnExer07.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=6I0NiRc6yww")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)


        }
    }
}