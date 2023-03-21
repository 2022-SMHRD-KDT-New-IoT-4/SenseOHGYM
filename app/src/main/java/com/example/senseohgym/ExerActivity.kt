package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// 메인 페이지 - 예약/취소하기 탭에서 두번째 버튼에 기구 정보 탭 시작 액티비티입니다
class ExerActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exer)

        val btnExer1 = findViewById<Button>(R.id.btnExer1)
        val btnEx2 = findViewById<Button>(R.id.btnEx2)
        val btnEx3 = findViewById<Button>(R.id.btnEx3)
        val btnEx4 = findViewById<Button>(R.id.btnEx4)
        val btnEx5 = findViewById<Button>(R.id.btnEx5)
        val btnEx6 = findViewById<Button>(R.id.btnEx6)
        val btnEx7 = findViewById<Button>(R.id.btnEx7)
        val btnEx8 = findViewById<Button>(R.id.btnEx8)
        val btnEx9 = findViewById<Button>(R.id.btnEx9)
        val btnEx10 = findViewById<Button>(R.id.btnExer10)

        btnExer1.setOnClickListener {
            val intent = Intent(this, Ex1Activity::class.java)
            startActivity(intent)
        }
        btnEx2.setOnClickListener {
            val intent = Intent(this, Ex2Activity::class.java)
            startActivity(intent)
        }
        btnEx3.setOnClickListener {
            val intent = Intent(this, Ex3Activity::class.java)
            startActivity(intent)
        }
        btnEx4.setOnClickListener {
            val intent = Intent(this, Ex4Activity::class.java)
            startActivity(intent)
        }
        btnEx5.setOnClickListener {
            val intent = Intent(this, Ex5Activity::class.java)
            startActivity(intent)
        }
        btnEx6.setOnClickListener {
            val intent = Intent(this, Ex6Activity::class.java)
            startActivity(intent)
        }
        btnEx7.setOnClickListener {
            val intent = Intent(this, Ex7Activity::class.java)
            startActivity(intent)
        }
        btnEx8.setOnClickListener {
            val intent = Intent(this, Ex8Activity::class.java)
            startActivity(intent)
        }
        btnEx9.setOnClickListener {
            val intent = Intent(this, Ex9Activity::class.java)
            startActivity(intent)
        }
        btnEx10.setOnClickListener {
            val intent = Intent(this, Ex10Activity::class.java)
            startActivity(intent)
        }
    }
}