package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AdminActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val member_reg = findViewById<ImageButton>(R.id.member_reg)
        val exer_reg = findViewById<ImageButton>(R.id.exer_reg)
        //val MemberManage = findViewById<ImageButton>(R.id.MemberManage)

        member_reg.setOnClickListener {
            val intent = Intent(this, MemberRegActivity::class.java)
            startActivity(intent)
        }

//        exer_reg.setOnClickListener {
//            val intent = Intent(this, ManageActivity::class.java)
//            startActivity(intent)
//        }

        // MemberManage 버튼에 문제가 생겨서 일단 해보는 코드
        exer_reg.setOnClickListener {
            val manageIntent = Intent(this, ManageActivity::class.java)
            manageIntent.putExtra("gym_name",intent.getStringExtra("gym_name"))

            startActivity(manageIntent)
        }



        // 회원관리 페이지
//        MemberManage.setOnClickListener {
//            val manageIntent = Intent(this, ManageActivity::class.java)
//            manageIntent.putExtra("gym_name",intent.getStringExtra("gym_name"))
//
//            startActivity(manageIntent)
//
//        }


    }
}