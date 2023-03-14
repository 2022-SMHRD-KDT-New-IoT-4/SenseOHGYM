package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import kotlin.math.log

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
            val intent1 = Intent(this, MyHealthActivity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card",mb_card) // 카드번호 담아주기
            Log.d("카드번호 확인(운동정보) : ", mb_card.toString())
            startActivity(intent1)
        }

        // 2번째 이미지 예약/취소로 가지는
        btnRev.setOnClickListener {
            val intent1 = Intent(this@MainActivity, Rev1_1Activity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card",mb_card) // 카드번호 담아주기
            Log.d("카드번호 확인(예약/취소) : ",mb_card.toString())
            startActivity(intent1)
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