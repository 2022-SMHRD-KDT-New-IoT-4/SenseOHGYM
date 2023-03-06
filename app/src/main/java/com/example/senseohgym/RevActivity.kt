package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RevActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rev)

        val btnRev1 = findViewById<Button>(R.id.btnRev1)
        val btnRev2 = findViewById<Button>(R.id.btnEx2)
        val btnRev3 = findViewById<Button>(R.id.btnEx3)


        btnRev1.setOnClickListener {
            val intent = Intent(this, Rev1_1Activity::class.java)
            startActivity(intent)
        }
        btnRev2.setOnClickListener {

        }
        btnRev3.setOnClickListener {

        }
    }
}