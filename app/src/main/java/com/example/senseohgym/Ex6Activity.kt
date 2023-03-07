package com.example.senseohgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex6Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex6)
        val rc6 = findViewById<RecyclerView>(R.id.rc6)

        val ex6List = ArrayList<Ex1VO>()

        ex6List.add(Ex1VO("바벨 바이셉 컬", "팔 앞쪽 강화", R.drawable.ex61))
        ex6List.add(Ex1VO("케이블 바이셉 컬", "팔 앞쪽 강화", R.drawable.ex62))
        ex6List.add(Ex1VO("친업", "팔 앞쪽 및 등 맨몸", R.drawable.ex63))
        ex6List.add(Ex1VO("덤벨 프리쳐 컬", "매끄러운 팔 및 앞쪽 강화", R.drawable.ex64))
        ex6List.add(Ex1VO("덤벨 파이셉 컬", "매끄러운 팔 및 앞쪽 강화", R.drawable.ex65))
        ex6List.add(Ex1VO("이지바 바이셉 컬", "팔 앞쪽 강화", R.drawable.ex66))
        ex6List.add(Ex1VO("덤벨 해머 컬", "매끄러운 팔 및 앞쪽 강화", R.drawable.ex67))

        val adapter = Ex1Adapter(applicationContext, ex6List)
        rc6.adapter = adapter

        rc6.layoutManager = LinearLayoutManager(this)
    }
}