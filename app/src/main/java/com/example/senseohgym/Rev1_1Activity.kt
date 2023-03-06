package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Rev1_1Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rev11)

        val btnEx1 = findViewById<Button>(R.id.btnEx1)
        val btnEx2 = findViewById<Button>(R.id.btnEx2)
        val btnEx3 = findViewById<Button>(R.id.btnEx3)

        btnEx1.setOnClickListener {
            val intent = Intent(this, Rev1_1_1Activity::class.java)
            startActivity(intent)
            finish()
        }
        btnEx2.setOnClickListener {
            val intent = Intent(this, Rev1_1_2Activity::class.java)
            startActivity(intent)
            finish()
        }
        btnEx3.setOnClickListener {
            val intent = Intent(this, Rev1_1_3Activity::class.java)
            startActivity(intent)
            finish()
        }






    }
}