package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Ex9Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex9)


        val btnExer09 = findViewById<ImageButton>(R.id.btnExer09)

        btnExer09.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=2ZGmW0k-eUk")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
    }
}}