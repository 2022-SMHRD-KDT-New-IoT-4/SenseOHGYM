package com.example.senseohgym

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex1Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex1)

        val rc1 = findViewById<RecyclerView>(R.id.rc1)

        val ex1List = ArrayList<Ex1VO>()

        ex1List.add(Ex1VO("벤치프레스", "전반적인 가슴 자극", R.drawable.ex11))
        ex1List.add(Ex1VO("덤벨 벤치 프레스", "전반적인 가슴 자극", R.drawable.ex12))
        ex1List.add(Ex1VO("덤벨 풀오버", "가슴, 상체 근육", R.drawable.ex13))
        ex1List.add(Ex1VO("펙덱 플라이", "가슴 근육 라인", R.drawable.ex14))
        ex1List.add(Ex1VO("덤벨 플라이", "가슴 바깥쪽 라인", R.drawable.ex15))
        ex1List.add(Ex1VO("푸쉬업", "전반적인 가슴 자극", R.drawable.ex16))
        ex1List.add(Ex1VO("케이블 크로스오버", "전반적인 가슴 자극", R.drawable.ex17))

        val adapter = Ex1Adapter(applicationContext, ex1List)
        rc1.adapter = adapter

        rc1.layoutManager = LinearLayoutManager(this)


    }
}