package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

// 메인 화면 들어가기전 잠깐 떴다 사라지는 화면입니다
// 스플래쉬에서 로그인 액티비티로 가고..
// 관리자는 아이디에 admin // 비번에 admin 치면 관리자 페이지로 가고
// 회원은 아이디에 이름 치고 // 비번에 카드 번호 치면 회원 페이지로 가지고..

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed(
            {
                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            },
            2500
        )
    }
}