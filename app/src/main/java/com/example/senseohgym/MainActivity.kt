package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlin.math.log

// 메인 화면 액티비티입니다
class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast?.cancel()
            super.onBackPressed()
            finish() // 현재 액티비티 종료
            return
        } else {
            backToast = Toast.makeText(
                this,
                "한번 더 누르시면 앱이 종료됩니다.",
                Toast.LENGTH_SHORT
            )
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMachine = findViewById<ImageButton>(R.id.btnMachine)
        val btnRev = findViewById<ImageButton>(R.id.btnRev)
        val btnExerInfo = findViewById<ImageButton>(R.id.btnExerInfo)
        val btnSetting = findViewById<ImageButton>(R.id.btnSetting)
        val textal = findViewById<TextView>(R.id.textal)


        // 1번째 운동정보로 가지는 ( 차트랑 표 있는.. )
        btnMachine.setOnClickListener {
            val intent1 = Intent(this, MyHealthActivity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card", mb_card) // 카드번호 담아주기
            Log.d("카드번호 확인(운동정보) : ", mb_card.toString())
            startActivity(intent1)
        }

        // 2번째 이미지 예약/취소로 가지는
        btnRev.setOnClickListener {
            val intent1 = Intent(this@MainActivity, Rev1_1Activity::class.java)
            val mb_card = intent.getStringExtra("mb_card")
            intent1.putExtra("mb_card", mb_card) // 카드번호 담아주기
            Log.d("카드번호 확인(예약/취소) : ", mb_card.toString())
            startActivity(intent1)
        }


        // 3번째 기구정보로 가지는..
        btnExerInfo.setOnClickListener {
            val intent = Intent(this, ExerActivity::class.java)
            startActivity(intent)
        }

        // 4번째 설정페이지로 가지는...도움말 페이지 구현
        btnSetting.setOnClickListener {
            val intent = Intent(this, MemberHelpActivity::class.java)
            startActivity(intent)
        }

        textal.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(v: View?) {
                val builder: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@MainActivity)
                builder.setTitle("예약하신 운동기구에서\n사용알림이 도착하였습니다.")
                builder.setPositiveButton("운동하러 가기",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(applicationContext, "Confirm", Toast.LENGTH_LONG).show()
                        dialog.cancel()
                    })
                builder.setNegativeButton("취소",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(applicationContext, "Clicked Cancel", Toast.LENGTH_SHORT)
                            .show()
                        dialog.cancel()
                    })
                val alertD: android.app.AlertDialog? = builder.create()
                alertD?.show()
            }

            override fun onClick(p0: DialogInterface?, p1: Int) {
                TODO("Not yet implemented")
            }
        })

    }
}