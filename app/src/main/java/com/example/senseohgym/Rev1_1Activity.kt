package com.example.senseohgym

import android.annotation.SuppressLint
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






    }
}