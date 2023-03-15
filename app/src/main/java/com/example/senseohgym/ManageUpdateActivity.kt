package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class ManageUpdateActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var updateRequest : StringRequest
    private lateinit var deleteRequest : StringRequest
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_update)

        queue = Volley.newRequestQueue(this)
        val updateName = findViewById<EditText>(R.id.updateName)
        val updateCard = findViewById<EditText>(R.id.updateCard)
        val updateBirth = findViewById<EditText>(R.id.updateBirth)
        val updateHealth = findViewById<EditText>(R.id.updateHealth)
        val rg2 = findViewById<RadioGroup>(R.id.rg2)
        val chMan2 = findViewById<RadioButton>(R.id.chMan2)
        val chWoman2 = findViewById<RadioButton>(R.id.chWoman2)
        val btnbtnUpdate = findViewById<Button>(R.id.btnbtnUpdate)
        val btnDelete = findViewById<Button>(R.id.btnDelete)

        val mbName = intent.getStringExtra("name")
        val mbCard = intent.getStringExtra("card")
        val mbBirth = intent.getStringExtra("birth")
        val mbGender = intent.getStringExtra("gender") // 이름 바꿔주기 manageAdapter까지
        val mbJoinDate = intent.getStringExtra("joindate")
        val gymName = intent.getStringExtra("gym_name")

        // 라디오버튼 체크 값 넣어놓기
        if(mbGender == "남"){
            chMan2.isChecked = true
        }else {
            chWoman2.isChecked = true
        }

        updateName.setText(mbName)
        updateCard.setText(mbCard)
        updateBirth.setText(mbBirth)
        updateHealth.setText(gymName)

//        updateAge.setText(mbAge)
//        updateName.setText(mbJoinDate)

        var check = ""
        rg2.setOnCheckedChangeListener { group, checkid ->
            if (checkid == R.id.chMan2) {
                check = "남"
            } else {
                check = "여"
            }
        }


        // 회원정보 수정
        btnbtnUpdate.setOnClickListener {
            val intent = Intent(this, ManageActivity::class.java)

            // 요청 보낼 서버 주소
            var url = "http://211.107.188.212:8081/Senseohgym/Member_Update.do"

            // 요청 생성 POST 방식
            updateRequest = object : StringRequest(
                Method.POST, url,
                {response ->
                    Log.d("결과",response.toString())
                    val result : Int = response.toInt()
                    if(result > 0){
                        Toast.makeText(this,"회원수정완료", Toast.LENGTH_SHORT).show()
                        intent.putExtra("gym_name",updateHealth.text.toString())
                    }else{
                        Toast.makeText(this,"회원수정실패", Toast.LENGTH_SHORT).show()
                        intent.putExtra("gym_name",gymName)
                    }
                    startActivity(intent)
                },
                {error ->
                    Log.d("통신오류", error.printStackTrace().toString());
                }){
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String>? {
                    val params : MutableMap<String, String> = HashMap()

                    params["mb_name"] = updateName.text.toString()
                    params["mb_card"] = updateCard.text.toString()
                    params["mb_birthdate"] = updateBirth.text.toString()
                    params["mb_gender"] = check
                    params["gym_name"] = updateHealth.text.toString()

                    return params
                }
            }

            updateRequest.setShouldCache(false)
            queue.add(updateRequest)


            startActivity(intent)
        }

        // 회원정보 삭제
        btnDelete.setOnClickListener {
            val intent = Intent(this, ManageActivity::class.java)

            // 요청 보낼 서버 주소
            var url = "http://211.107.188.212:8081/Senseohgym/Member_Delete.do"

            deleteRequest = object : StringRequest(
                Method.POST, url,
                {response ->
                    Log.d("결과",response.toString())
                    val result : Int = response.toInt()
                    if(result > 0){
                        Toast.makeText(this,"회원삭제완료", Toast.LENGTH_SHORT).show()
                        intent.putExtra("gym_name",updateHealth.text.toString())
                    }else{
                        Toast.makeText(this,"회원삭제실패", Toast.LENGTH_SHORT).show()
                        intent.putExtra("gym_name",gymName)
                    }
                    startActivity(intent)
                },
                {error ->
                    Log.d("통신오류", error.printStackTrace().toString());
                }){
                @Throws(AuthFailureError::class)
                override fun getParams(): MutableMap<String, String>? {
                    val params : MutableMap<String, String> = HashMap()

                    params["mb_name"] = updateName.text.toString()
                    params["mb_card"] = updateCard.text.toString()
                    params["gym_name"] = updateHealth.text.toString()

                    return params
                }
            }

            deleteRequest.setShouldCache(false)
            queue.add(deleteRequest)


            startActivity(intent)
        }


    }
}