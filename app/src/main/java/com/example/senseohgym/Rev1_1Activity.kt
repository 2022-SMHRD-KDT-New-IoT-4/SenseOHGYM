package com.example.senseohgym

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest

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

        var mb_card = intent.getStringExtra("mb_card")
        Log.d("예약페이지 카드번호 확인",mb_card.toString())


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


        val adapter = RevAdapter(applicationContext, revExer, mb_card.toString()) //파라미터값으로 mb_card 변수 추가



        rcRev.adapter = adapter
        rcRev.layoutManager = LinearLayoutManager(this)



    }
}