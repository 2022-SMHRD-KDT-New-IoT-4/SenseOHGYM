package com.example.senseohgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex8Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex8)

        val rc8 = findViewById<RecyclerView>(R.id.rc8)

        val ex8List = ArrayList<Ex1VO>()

        ex8List.add(Ex1VO("덤벨 리스트 컬", "팔뚝 및 팔 앞쪽 강화", R.drawable.ex81))
        ex8List.add(Ex1VO("바벨 리스트 컬", "팔뚝 및 팔 앞쪽 강화", R.drawable.ex82))
        ex8List.add(Ex1VO("리스트 롤러", "팔뚝 및 팔 앞쪽 강화", R.drawable.ex83))
        ex8List.add(Ex1VO("리버스 바벨 리스트 컬", "팔뚝 및 팔 앞쪽 강화", R.drawable.ex84))
        ex8List.add(Ex1VO("리버스 덤벨 리스트 컬", "팔뚝 및 팔 앞쪽 강화", R.drawable.ex85))


        val adapter = Ex1Adapter(applicationContext, ex8List)
        rc8.adapter = adapter

        rc8.layoutManager = LinearLayoutManager(this)
    }
}