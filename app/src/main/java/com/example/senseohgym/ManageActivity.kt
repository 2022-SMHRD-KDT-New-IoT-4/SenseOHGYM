package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import java.lang.invoke.MethodHandle

// 관리자가 회원정보 관리하는 페이지 입니다.
class ManageActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest
    //private lateinit var result : JSONArray
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage)


        val manageRc = findViewById<RecyclerView>(R.id.manageRc)
        val tvManageTitle = findViewById<TextView>(R.id.tvManageTitle)



        // 서버와 통신하는 부분
        queue = Volley.newRequestQueue(this)
        val gym_name = intent.getStringExtra("gym_name").toString()
        tvManageTitle.text = gym_name

        val url = "http://211.107.188.212:8081/Senseohgym/Member_SelectAll.do"

        request = object : StringRequest(
            Method.POST, url,
            {response ->
                Log.d("회원목록 결과",response.toString())
                val result = JSONArray(response)

                val manage_list = ArrayList<manageVO>()

                for(i in 0 until result.length()){
                    val manage = result.getJSONObject(i)
                    manage_list.add(manageVO(
                        manage.getString("mb_name"),
                        manage.getString("mb_card"),
                        manage.getString("mb_birthdate"),
                        manage.getString("mb_gender"),
                        manage.getString("mb_joindate"),
                        manage.getString("gym_name")
                    ))
                }

                //manage_list.add(manageVO("김깅지","120","11.11.11","남","23.03.10"))

                val adapter = manageAdapter(this, manage_list)
                manageRc.adapter = adapter
                manageRc.layoutManager = LinearLayoutManager(this)

//                btnManage.setOnClickListener {
//                    val intent = Intent(this, ManageUpdateActivity::class.java)
//
//
//                    startActivity(intent)
//                }
            },
            {error ->
                Log.d("통신오류", error.printStackTrace().toString())
            })


        {
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params : MutableMap<String, String> = HashMap()

                params["gym_name"] = gym_name

                return params
            }
        }

        request.setShouldCache(false)
        queue.add(request)






//        val manage_list = ArrayList<manageVO>()
//
//        for(i in 0 until result.length()){
//            val manage = result.getJSONObject(i)
//            manage_list.add(manageVO(manage.getString("mb_name",),manage.getString("mb_card"),
//            manage.getString("mb_birthdate"),manage.getString("mb_gender"), manage.getString("mb_joindate")))
//        }
//
//        //manage_list.add(manageVO("김깅지","120","11.11.11","남","23.03.10"))
//
//        val adapter = manageAdapter(applicationContext, manage_list)
//        manageRc.adapter = adapter
//        manageRc.layoutManager = LinearLayoutManager(this)
//
//        btnManage.setOnClickListener {
//            val intent = Intent(this, ManageUpdateActivity::class.java)
//            startActivity(intent)
//        }



    }
}