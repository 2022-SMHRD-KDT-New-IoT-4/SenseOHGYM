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

            queue = Volley.newRequestQueue(this@PopupActivity)
            val etUseTime = findViewById<EditText>(R.id.etUseTime)
            val btn_OK = findViewById<Button>(R.id.btn_OK) // 팝업창 확인 버튼(사용할 시간 입력 팝업창)
            val btn_Can = findViewById<Button>(R.id.btn_Can) //팝업창 취소 버튼(사용할 시간 입력 팝업창)

            val exer_name = intent.getStringExtra("exername") // 사용기구명
            val mb_card = intent.getStringExtra("mb_card") // 카드번호

            // 예약관련파일 url 값
            var url = "http://221.156.243.155:8081/Senseohgym3/Reservation_Join.do"


            btn_OK.setOnClickListener {
                Toast.makeText(this@PopupActivity, "돼니??", Toast.LENGTH_SHORT).show()


                val intent = Intent(this@PopupActivity, Rev1_1Activity::class.java)

                var etUseTime = etUseTime.text.toString()


                // 시간 입력 잘되나 확인해보는코드
                Log.d("시간확인", "사용할 시간: $etUseTime")
                // 기구정보 잘 넘어오나 확인
                Log.d("기구확인", "사용할 기구: $exer_name")
                // 카드번호 잘 넘어오나 확인
                Log.d("카드번호 확인_PopupActivity", mb_card.toString())

                // 요청 생성 POST방식
                request = object : StringRequest(Method.POST, url,
                    { response ->
                        Log.d("결과", response.toString())
                        if(response.toString() == "예약을 하기 위한 값들이 충분하지 않습니다.") {
                            Toast.makeText(context, "예약 조건이 충분하지 않습니다. 재시도 바람", Toast.LENGTH_SHORT).show()

                        }else{
                            Toast.makeText(context, "예약성공!", Toast.LENGTH_SHORT).show()

                            val response1 = JSONObject(response)
                            startActivity(intent)
                        }
                    },
                    { error ->
                        Log.d("통신오류", error.printStackTrace().toString());
                    }

                ) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): MutableMap<String, String>? {
                        val params: MutableMap<String, String> = HashMap()

                        params["etUseTime"] = etUseTime
                        params["exername"] = exer_name.toString()
                        params["mb_card"] = mb_card.toString()

                        return params
                    }
                }

                request.setShouldCache(false)
                queue.add(request)

                startActivity(intent)

            }
            btn_Can.setOnClickListener {
                finish()
            }

        }
    }
}