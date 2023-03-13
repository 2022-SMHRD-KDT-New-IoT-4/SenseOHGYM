package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

// 실시간 기구 사용여부에 .. 들어오면 운동 기구 목록이 보여지는 화면입니다
// 여기서 바로 기구 예약하기를 사용할 수 있어야함..


class Rev1_1Activity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request: StringRequest

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rev11)

        val rcRev = findViewById<RecyclerView>(R.id.rcRev)
        val mb_card = intent.getStringExtra("mb_card").toString()


//        queue = Volley.newRequestQueue(this@Rev1_1Activity)

//        var url =
//            "http://221.156.185.168:8081/Senseohgym/Member_Login.do"

        val revExer = ArrayList<RevVo>()

        revExer.add(RevVo("운동기구1", "예약여부"))
        revExer.add(RevVo("운동기구2", "예약여부"))
        revExer.add(RevVo("운동기구3", "예약여부"))
        revExer.add(RevVo("운동기구4", "예약여부"))
        revExer.add(RevVo("운동기구5", "예약여부"))
        revExer.add(RevVo("운동기구6", "예약여부"))
        revExer.add(RevVo("운동기구7", "예약여부"))
        revExer.add(RevVo("운동기구8", "예약여부"))
        revExer.add(RevVo("운동기구9", "예약여부"))

        val adapter = RevAdapter(applicationContext, revExer, mb_card)
        rcRev.adapter = adapter
        rcRev.layoutManager = LinearLayoutManager(this)



    }
}