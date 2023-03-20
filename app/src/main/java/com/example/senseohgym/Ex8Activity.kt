package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Ex8Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex8)

        val btnExer08 = findViewById<ImageButton>(R.id.btnExer08)

        btnExer08.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=uAG-sm4KnOo")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)

        }
    }
}