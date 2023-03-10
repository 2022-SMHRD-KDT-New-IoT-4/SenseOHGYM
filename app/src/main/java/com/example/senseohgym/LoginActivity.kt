package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        queue = Volley.newRequestQueue(this)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val etName = findViewById<EditText>(R.id.etName)
        val etGymName = findViewById<EditText>(R.id.etGymName)
        val etCard = findViewById<EditText>(R.id.etCard)

        // 요청 보낼 서버 주소
        var url = "http://211.107.188.212:8081/Senseohgym/Member_Login.do"

        btnLogin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            var gymName = etGymName.text.toString()
            var name = etName.text.toString()
            var card = etCard.text.toString()

            intent.putExtra("gymName", gymName)
            intent.putExtra("name", name)
            intent.putExtra("card", card)

            // 요청 생성 POST 방식
            request = object : StringRequest(
                Method.POST, url,
                {response ->
                    Log.d("결과",response.toString())
                    if(response.toString() == "회원등록필요"){
                        Toast.makeText(this,"회원등록이 필요합니다.", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"로그인성공!", Toast.LENGTH_SHORT).show()
                        val response1 = JSONObject(response)

                        startActivity(intent)
                    }
                },
                {error ->
                    Log.d("통신오류", error.printStackTrace().toString());
                }){
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String>? {
                    val params : MutableMap<String, String> = HashMap()

                    params["gym_name"] = gymName
                    params["mb_name"] = name
                    params["mb_card"] = card

                    return params
                }
            }

            request.setShouldCache(false)
            queue.add(request)


        }


    }
}