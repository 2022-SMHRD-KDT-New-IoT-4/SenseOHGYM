package com.example.senseohgym

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)

        val btnExer02 = findViewById<ImageButton>(R.id.btnExer02)

        btnExer02.setOnClickListener {
            val uri = Uri.parse("https://www.youtube.com/watch?v=ppPQgmgpafM")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)


        }


    }
}