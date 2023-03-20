package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex5Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex5)

        val btnExer05 = findViewById<ImageButton>(R.id.btnExer05)

        btnExer05.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=YntwjLKHlLk")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)


        }

    }
}