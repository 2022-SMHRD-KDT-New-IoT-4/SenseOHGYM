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
        val MemberManage = findViewById<ImageButton>(R.id.MemberManage)

        val gym_name = intent.getStringExtra("gym_name")

        member_reg.setOnClickListener {
            val intent = Intent(this, MemberRegActivity::class.java)
            intent.putExtra("gym_name", gym_name)
            startActivity(intent)
        }

        exer_reg.setOnClickListener {
            val exIntent = Intent(this, MachineDataActivity::class.java)
            exIntent.putExtra("gym_name",intent.getStringExtra("gym_name").toString())
            startActivity(exIntent)
        }

        MemberManage.setOnClickListener {
            val manageIntent = Intent(this, ManageActivity::class.java)
            manageIntent.putExtra("gym_name", intent.getStringExtra("gym_name").toString())
            startActivity(manageIntent)
        }


    }
}