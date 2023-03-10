package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AdminActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val member_reg = findViewById<ImageButton>(R.id.member_reg)
        val exer_reg = findViewById<ImageButton>(R.id.exer_reg)

        member_reg.setOnClickListener {
            val intent = Intent(this, MemberRegActivity::class.java)
            startActivity(intent)
        }

        exer_reg.setOnClickListener {
            val intent = Intent(this, MachineDataActivity::class.java)
            startActivity(intent)
        }


    }
}