package com.example.senseohgym

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        val btn_rev = findViewById<Button>(R.id.btn_rev)
        val rcRev = findViewById<RecyclerView>(R.id.rcRev)
        val mb_card = intent.getStringExtra("mb_card").toString()
        Log.d("예약페이지 카드번호 확인",mb_card.toString())

        queue = Volley.newRequestQueue(this@Rev1_1Activity)

        var url =
            "http://211.107.188.212:8081/Senseohgym/Reservation_after.do"

        val revExer = ArrayList<RevVo>()

        revExer.add(RevVo("chestFly", "예약가능"))
        revExer.add(RevVo("chestPress", "예약가능"))
        revExer.add(RevVo("pullUp", "예약가능"))
        revExer.add(RevVo("latPullDown", "예약가능"))
        revExer.add(RevVo("armPullDown", "예약가능"))
        revExer.add(RevVo("legPress", "예약가능"))
        revExer.add(RevVo("legCurl", "예약가능"))
        revExer.add(RevVo("vSquat", "예약가능"))
        revExer.add(RevVo("facePull", "예약가능"))
        revExer.add(RevVo("dips", "예약가능"))

        val adapter = RevAdapter(applicationContext, revExer, mb_card.toString()) //파라미터값으로 mb_card 변수 추가
        adapter.SetOnItemClickListener(object : RevAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                finish()
            // adapter사용해서 열린 activity 닫는 방법 >> adapter내부에 item 클릭했을 때 실행할 수 있는 interface 함수를 하나 정의
            }
        })
        rcRev.adapter = adapter
        rcRev.layoutManager = LinearLayoutManager(this)
    }
}