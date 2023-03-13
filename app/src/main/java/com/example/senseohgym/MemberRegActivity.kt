package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MemberRegActivity : AppCompatActivity() {
    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_reg)


        queue  = Volley.newRequestQueue(this)

        val btnMemberJoin = findViewById<Button>(R.id.btnMemberJoin)
        val mb_gender = findViewById<RadioGroup>(R.id.rg) // 성별
        val mb_card = findViewById<EditText>(R.id.etCard) // 회원카드
        val mb_name = findViewById<EditText>(R.id.etName) // 회원이름
        val gym_name = findViewById<EditText>(R.id.etGymName) // 헬스장이름
        val mb_birthdate = findViewById<EditText>(R.id.etBitrhday) // 생년월일
        val mb_type1 = findViewById<EditText>(R.id.etType) // 회원유형

        var url = "http://221.156.243.155:8081/Senseohgym3/Member_Join.do"


        var check = ""
        mb_gender.setOnCheckedChangeListener { group, checkid ->
            if (checkid == R.id.chMan) {
                check = "남"
            } else {
                check = "여"
            }
        }

        btnMemberJoin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val birthday = mb_birthdate.text.toString()
            val name = mb_name.text.toString()
            val gymName = gym_name.text.toString()
            val type = mb_type1.text.toString()
            val card = mb_card.text.toString()

//          이름 통일 필요
            intent.putExtra("mb_gender", check)
            intent.putExtra("mb_birthdate", birthday)
            intent.putExtra("mb_name", name)
            intent.putExtra("gym_name", gymName)
            intent.putExtra("mb_type", type)
            intent.putExtra("mb_card", card)

            // 요청 생성 POST 방식
            request = object : StringRequest(
                Method.POST, url,
                { response ->
                    Log.d("결과", response.toString())
                    if (response.toString() == "회원등록에 필요한 모든 값을 입력하세요") {
                        Toast.makeText(this, "회원등록 재시도 바람.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "회원등록성공!", Toast.LENGTH_SHORT).show()


                        startActivity(intent)

                    }
                },
                { error ->
                    Log.d("통신오류", error.printStackTrace().toString());
                }) {
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String>? {
                    val params: MutableMap<String, String> = HashMap()

                    params["mb_gender"] = check
                    params["mb_birthdate"] = birthday
                    params["mb_name"] = name
                    params["gym_name"] = gymName
                    params["mb_type"] = type
                    params["mb_card"] = card

                    return params
                }
            }

            request.setShouldCache(false)
            queue.add(request)

        }
    }
}