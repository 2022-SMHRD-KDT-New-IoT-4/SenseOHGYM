package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex4Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4)

        val btnExer04 = findViewById<ImageButton>(R.id.btnExer04)

        btnExer04.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=upRe2E2bLlQ")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)


        }

    }
}