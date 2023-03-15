package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex3Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3)

        val btnExer03 = findViewById<ImageButton>(R.id.btnExer03)

        btnExer03.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=nWhS28U6bCY")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)



        }



    }
}