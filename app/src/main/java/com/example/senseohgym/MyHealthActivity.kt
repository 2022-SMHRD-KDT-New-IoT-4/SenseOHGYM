package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyHealthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_health)

        val btnHealthTime = findViewById<Button>(R.id.btnHealthTime)
        val btnCount = findViewById<Button>(R.id.btnCount)

        btnHealthTime.setOnClickListener{
           val intent =  Intent(this, ChartActivity::class.java)

            // 보내줄 데이터...?
            startActivity(intent)
        }

        btnCount.setOnClickListener{
            val intent = Intent(this, hyesuActivity::class.java)
            startActivity(intent)
        }
    }
}