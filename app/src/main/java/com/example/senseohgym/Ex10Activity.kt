package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Ex10Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex10)

        val btnExer10 = findViewById<ImageButton>(R.id.btnExer10)

        btnExer10.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=pQSfXvaQGas")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }
}