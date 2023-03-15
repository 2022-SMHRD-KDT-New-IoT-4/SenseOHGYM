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
        val mb_card = intent.getStringExtra("mb_card").toString()
        Log.d("예약페이지 카드번호 확인",mb_card.toString())

//        queue = Volley.newRequestQueue(this@Rev1_1Activity)

//        var url =
//            "http://221.156.185.168:8081/Senseohgym/Member_Login.do"

        val revExer = ArrayList<RevVo>()

        revExer.add(RevVo("chest fly", "예약여부"))
        revExer.add(RevVo("chest press", "예약여부"))
        revExer.add(RevVo("pull up", "예약여부"))
        revExer.add(RevVo("lat pull down", "예약여부"))
        revExer.add(RevVo("arm pull down", "예약여부"))
        revExer.add(RevVo("leg press", "예약여부"))
        revExer.add(RevVo("leg curl", "예약여부"))
        revExer.add(RevVo("v squat", "예약여부"))
        revExer.add(RevVo("face pull", "예약여부"))
        revExer.add(RevVo("dips", "예약여부"))


        val adapter = RevAdapter(applicationContext, revExer, mb_card.toString()) //파라미터값으로 mb_card 변수 추가
        rcRev.adapter = adapter
        rcRev.layoutManager = LinearLayoutManager(this)



    }
}