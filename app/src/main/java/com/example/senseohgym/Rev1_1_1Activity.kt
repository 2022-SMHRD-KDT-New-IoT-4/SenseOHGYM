package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

// 예약 취소 탭에서 운동기구 목록을 눌러 들어가게 되면
// 1번 운동 기구의 예약하기와 취소하기 버튼이 존재하는 액티비티입니다.
class Rev1_1_1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rev111)

        val btnRev1R = findViewById<Button>(R.id.btnRev1R)
        val btnRev1C = findViewById<Button>(R.id.btnRev1C)

        btnRev1R.setOnClickListener {
            val intent = Intent(this, PopupActivity::class.java)
            startActivity(intent)

        }




    }
}