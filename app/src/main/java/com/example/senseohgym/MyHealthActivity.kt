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

        btnHealthTime.setOnClickListener {
            val intent1 = Intent(this, ChartActivity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card",mb_card) // 카드번호 담아주기
            // 보내줄 데이터...?
            startActivity(intent1)
        }

        btnCount.setOnClickListener {
            val intent1 = Intent(this, hyesuActivity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card",mb_card) // 카드번호 담아주기
            startActivity(intent1)
        }
    }
}