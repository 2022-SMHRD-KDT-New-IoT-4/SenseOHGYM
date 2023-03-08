package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

// 메인 화면 액티비티입니다
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMachine = findViewById<ImageButton>(R.id.btnMachine)
        val btnRev = findViewById<ImageButton>(R.id.btnRev)
        val btnExerInfo = findViewById<ImageButton>(R.id.btnExerInfo)
        val btnSetting = findViewById<ImageButton>(R.id.btnSetting)


        // 1번째 운동정보로 가지는 ( 차트랑 표 있는.. )
        btnMachine.setOnClickListener {
            val intent = Intent(this, ChartActivity::class.java)
            startActivity(intent)
        }

        // 2번째 이미지 예약/취소로 가지는
        btnRev.setOnClickListener {
            val intent = Intent(this@MainActivity, Rev1_1Activity::class.java)
            startActivity(intent)
        }

        // 3번째 기구정보로 가지는..
        btnExerInfo.setOnClickListener {
            val intent = Intent(this, ExerActivity::class.java)
            startActivity(intent)
        }

        // 4번째 설정페이지로 가지는...이건 그냥 빈페이지임..
        btnSetting.setOnClickListener {

        }


    }
}