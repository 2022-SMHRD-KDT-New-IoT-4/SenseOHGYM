package com.example.senseohgym

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex3Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3)

        val rc3 = findViewById<RecyclerView>(R.id.rc3)

        val ex3List = ArrayList<Ex1VO>()

        ex3List.add(Ex1VO("바벨 스쿼트","하체 기반 전신 운동", R.drawable.ex31))
        ex3List.add(Ex1VO("런지","엉덩이 허벅지 군살 제거", R.drawable.ex32))
        ex3List.add(Ex1VO("레그 프레스","허벅지 앞쪽 지붕", R.drawable.ex33))
        ex3List.add(Ex1VO("레그 컬","허벅지 뒤쪽 하체", R.drawable.ex34))
        ex3List.add(Ex1VO("바벨 스티프","허벅지 뒤쪽 하체", R.drawable.ex35))
        ex3List.add(Ex1VO("브이 스쿼트","엉덩이 자극 하체", R.drawable.ex36))
        ex3List.add(Ex1VO("레그 익스텐션","허벅지 앞쪽 자극", R.drawable.ex37))

        val adapter = Ex1Adapter(applicationContext, ex3List)
        rc3.adapter = adapter

        rc3.layoutManager = LinearLayoutManager(this)




    }
}