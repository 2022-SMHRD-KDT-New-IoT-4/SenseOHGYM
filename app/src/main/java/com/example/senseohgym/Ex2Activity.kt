package com.example.senseohgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)

        val rc2 = findViewById<RecyclerView>(R.id.rc2)

        val ex2List = ArrayList<Ex1VO>()

        ex2List.add(Ex1VO("데드리프트","전신 복합 자극", R.drawable.ex21))
        ex2List.add(Ex1VO("바벨 로우","두께감 있는 등", R.drawable.ex22))
        ex2List.add(Ex1VO("풀 업","넓은 어깨와 등", R.drawable.ex23))
        ex2List.add(Ex1VO("루마니안 데드리프트","두께감 있는 등", R.drawable.ex24))
        ex2List.add(Ex1VO("렛 풀다운","광배근 만들기", R.drawable.ex25))
        ex2List.add(Ex1VO("백 익스텐션","척추기립근 강화", R.drawable.ex26))
        ex2List.add(Ex1VO("원 암 덤벨 로우","광배근 만들기", R.drawable.ex27))

        val adapter = Ex1Adapter(applicationContext, ex2List)
        rc2.adapter = adapter

        rc2.layoutManager = LinearLayoutManager(this)


    }
}