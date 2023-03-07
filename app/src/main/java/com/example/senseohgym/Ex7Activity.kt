package com.example.senseohgym

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex7Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex7)

        val rc7 = findViewById<RecyclerView>(R.id.rc7)

        val ex7List = ArrayList<Ex1VO>()

        ex7List.add(Ex1VO("레그레이즈", "복근 하단 및 허리", R.drawable.ex71))
        ex7List.add(Ex1VO("크런치", "복근 상단 집중", R.drawable.ex72))
        ex7List.add(Ex1VO("케이블 크런치", "크런치 활용 중량 복근", R.drawable.ex73))
        ex7List.add(Ex1VO("캡틴스 체어 레그 레이즈","허리에 안전한 복근 하단", R.drawable.ex74))
        ex7List.add(Ex1VO("행잉 레그레이즈", "하단 복근 집중", R.drawable.ex75))
        ex7List.add(Ex1VO("바이시클 크런치", "전체적인 복근 자극", R.drawable.ex76))
        ex7List.add(Ex1VO("디클라인 크런치", "복근 상단 집중", R.drawable.ex77))

        val adapter = Ex1Adapter(applicationContext, ex7List)
        rc7.adapter = adapter

        rc7.layoutManager = LinearLayoutManager(this)

    }
}