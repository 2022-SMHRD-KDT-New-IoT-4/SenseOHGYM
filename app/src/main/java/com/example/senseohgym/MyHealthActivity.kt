package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MyHealthActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_health)



        // mb_card값 가져와서 Log로 값 잘나오는지 확인
        val mb_card = intent.getStringExtra("mb_card")
        Log.d("카드번호 확인(MyHealthActivity) : ", mb_card.toString())

        val btnHealthTime = findViewById<Button>(R.id.btnHealthTime)
        val btnCount = findViewById<Button>(R.id.btnCount)



        btnHealthTime.setOnClickListener {
            val intent1 = Intent(this, ChartActivity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card",mb_card) // 카드번호 담아주기
            Log.d("카드번호 확인(차트페이지) : ",mb_card.toString())
            // 보내줄 데이터...?
            startActivity(intent1)
        }

        btnCount.setOnClickListener {
            val intent1 = Intent(this, McActivity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card",mb_card) // 카드번호 담아주기
            Log.d("카드번호 확인(기구별사용횟수) : ",mb_card.toString())
            startActivity(intent1)
        }
    }
}