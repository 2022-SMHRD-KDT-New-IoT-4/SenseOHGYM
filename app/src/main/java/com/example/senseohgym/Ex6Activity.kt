package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Ex6Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex6)

        val btnExer06 = findViewById<ImageButton>(R.id.btnExer05)

        btnExer06.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=v8fTr5MEFkI")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)



        }

    }
}