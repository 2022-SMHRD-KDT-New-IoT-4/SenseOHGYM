package com.example.senseohgym

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class PopupActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request: StringRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_popup)

        window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            val etUseTime = findViewById<EditText>(R.id.etUseTime)
            val btn_OK = findViewById<Button>(R.id.btn_OK)
            val btn_Can = findViewById<Button>(R.id.btn_Can)

            queue = Volley.newRequestQueue(this@PopupActivity)

            val exer_name = intent.getStringExtra("exername") // 사용기구명
            val mb_card = intent.getStringExtra("mb_card") // 카드번호

            // 예약관련파일 url 값
            var url = "http://221.156.243.155:8081/Senseohgym/Reservation_Join.do"

            btn_OK.setOnClickListener {

                if (etUseTime.text.toString().toInt() <= 30) {
                    var intent = Intent(this@PopupActivity, Rev1_1Activity::class.java)

                    var etUseTime = etUseTime.text.toString()
                    // 시간 입력 잘되나 확인해보는코드
                    Log.d("시간확인", "사용할 시간: $etUseTime")
                    // 기구정보 잘 넘어오나 확인
                    Log.d("기구확인", "사용할 기구: $exer_name")
                    // 카드번호 잘 넘어오나 확인
                    Log.d("카드번호 확인_PopupActivity", mb_card.toString())

                    intent.putExtra("etUseTime", etUseTime)
                    intent.putExtra("exername", exer_name)
                    intent.putExtra("mb_card", mb_card)

                    // 요청 생성 POST방식
                    request = object : StringRequest(Method.POST, url,
                        { response ->
                            Log.d("확인", response.toString())
                            if (response.toInt() > 0) {
                                Toast.makeText(
                                    context,
                                    "예약 성공입니다.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                startActivity(intent)
                            } else {
                                Toast.makeText(context, "예약실패!", Toast.LENGTH_SHORT).show()
                                val response1 = JSONObject(response)
                            }
                        },
                        { error ->
                            Log.d("통신오류", error.printStackTrace().toString())
                        }
                    ) {
                        @Throws(AuthFailureError::class)
                        override fun getParams(): MutableMap<String, String>? {
                            val params: MutableMap<String, String> = HashMap()

                            params["use_time"] = etUseTime
                            params["rs_machine"] = exer_name.toString()
                            params["mb_card"] = mb_card.toString()

                            return params
                        }
                    }
                    request.setShouldCache(false)
                    queue.add(request)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(context, "30분 이내로 시간을 입력하세요.", Toast.LENGTH_SHORT).show()
                }
            }
            btn_Can.setOnClickListener {
                finish()
            }
        }
    }
}

