package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// 실시간 기구 사용여부에 .. 들어오면 운동 기구 목록이 보여지는 화면입니다
class Rev1_1Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rev11)

        val btnEx1 = findViewById<Button>(R.id.btnEx1)
        val btnEx2 = findViewById<Button>(R.id.btnEx)
        val btnEx3 = findViewById<Button>(R.id.btnIntro)

        btnEx1.setOnClickListener {
            val intent = Intent(this, Rev1_1_1Activity::class.java)
            startActivity(intent)
        }
        btnEx2.setOnClickListener {
            val intent = Intent(this, Rev1_1_2Activity::class.java)
            startActivity(intent)
        }
        btnEx3.setOnClickListener {
            val intent = Intent(this, Rev1_1_3Activity::class.java)
            startActivity(intent)

        }


    }
}