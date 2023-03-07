package com.example.senseohgym

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Ex4Activity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4)
        val rc4 = findViewById<RecyclerView>(R.id.rc4)

        val ex4List = ArrayList<Ex1VO>()

        ex4List.add(Ex1VO("오버헤드 프레스","전반적인 어깨자극", R.drawable.ex41))
        ex4List.add(Ex1VO("덤벨 숄더 프레스","넓은 어깨", R.drawable.ex42))
        ex4List.add(Ex1VO("덤벨 레터럴 라이즈","측면부 어깨", R.drawable.ex43))
        ex4List.add(Ex1VO("숄더 프레스 머신","어깨 볼륨 키우기", R.drawable.ex44))
        ex4List.add(Ex1VO("레터럴 레이즈 머신","측면부 어깨", R.drawable.ex45))
        ex4List.add(Ex1VO("시티드 오버헤드 프레스","어깨 볼륨 키우기", R.drawable.ex46))
        ex4List.add(Ex1VO("덤벨 프론트 레이즈","전면부 어깨 자극", R.drawable.ex47))

        val adapter = Ex1Adapter(applicationContext, ex4List)
        rc4.adapter = adapter

        rc4.layoutManager = LinearLayoutManager(this)
    }
}