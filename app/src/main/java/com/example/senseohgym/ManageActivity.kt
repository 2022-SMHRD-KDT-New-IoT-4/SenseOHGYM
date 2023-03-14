package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.lang.invoke.MethodHandle

// 관리자가 회원정보 관리하는 페이지 입니다.
class ManageActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)

        val btnManage = findViewById<Button>(R.id.btnManage)
        val manageRc = findViewById<RecyclerView>(R.id.manageRc)

        // 서버와 통신하는 부분
        queue = Volley.newRequestQueue(this)
        val gym_name = intent.getStringExtra("gym_name").toString()

        val url = "http://211.107.188.212:8081/Senseohgym/Member_SelectAll.do"

        request = object : StringRequest(
            Method.POST, url,
            {response ->

            },
            {error ->

            }){
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params : MutableMap<String, String> = HashMap()

                params["gym_name"] = gym_name

                return params
            }
        }

        request.setShouldCache(false)
        queue.add(request)


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