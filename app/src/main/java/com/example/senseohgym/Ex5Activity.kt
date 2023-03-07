package com.example.senseohgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex5)

        val rc5 = findViewById<RecyclerView>(R.id.rc5)

        val ex5List = ArrayList<Ex1VO>()

        ex5List.add(Ex1VO("바벨 트라이셉 익스텐션", "팔 뒤쪽 강화", R.drawable.ex51))
        ex5List.add(Ex1VO("케이블 트라이셉 푸쉬다운", "팔뚝살 및 팔 뒤쪽 강화", R.drawable.ex52))
        ex5List.add(Ex1VO("원 암 덤벨 킥벡", "팔뚝살 및 팔 뒤쪽 강화", R.drawable.ex53))
        ex5List.add(Ex1VO("덤벨 트라이셉 익스텐션", "팔뚝살 및 팔 뒤쪽 강화", R.drawable.ex54))
        ex5List.add(Ex1VO("원 암 덤벨 트라이셉 익스텐션", "팔뚝살 및 팔 뒤쪽 강화", R.drawable.ex55))
        ex5List.add(Ex1VO("벤치 딥스", "팔뚝살 및 팔 뒤쪽 강화", R.drawable.ex56))
        ex5List.add(Ex1VO("원 암 케이블 킥백", "팔뚝살 및 팔 뒤쪽 강화", R.drawable.ex57))

        val adapter = Ex1Adapter(applicationContext, ex5List)
        rc5.adapter = adapter

        rc5.layoutManager = LinearLayoutManager(this)

    }
}