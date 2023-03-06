package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMachine = findViewById<ImageButton>(R.id.btnMachine)
        val btnRev = findViewById<ImageButton>(R.id.btnRev)
        val btnCall = findViewById<ImageButton>(R.id.btnCall)
        val btnBoard = findViewById<ImageButton>(R.id.btnBoard)
        val btnMsg = findViewById<ImageButton>(R.id.btnMsg)
        val btnLog = findViewById<ImageButton>(R.id.btnLog)


        // 예약/취소로 가지는

        btnRev.setOnClickListener {
            val intent = Intent(this, RevActivity::class.java)
            startActivity(intent)
        }
        // 게시판으로 가지는
        btnBoard.setOnClickListener {
            val intent = Intent(this, BoardActivity::class.java)
            startActivity(intent)
        }
        btnLog.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }






    }
}