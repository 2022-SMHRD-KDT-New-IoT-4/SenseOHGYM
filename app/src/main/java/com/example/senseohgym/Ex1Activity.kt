package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex1Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)

        val btnExer01 = findViewById<ImageButton>(R.id.btnExer01)

        btnExer01.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=mQaWB0Iv7eE")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)


        }


    }
}