package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// 관리자가 회원정보 관리하는 페이지 입니다.
class ManageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)

        val btnManage = findViewById<Button>(R.id.btnManage)
        val manageRc = findViewById<RecyclerView>(R.id.manageRc)

        val manage_list = ArrayList<manageVO>()

        manage_list.add(manageVO("김깅지","120","11.11.11","남","23.03.10"))

        val adapter = manageAdapter(applicationContext, manage_list)
        manageRc.adapter = adapter
        manageRc.layoutManager = LinearLayoutManager(this)

        btnManage.setOnClickListener {
            val intent = Intent(this, ManageUpdateActivity::class.java)
            startActivity(intent)
        }



    }
}