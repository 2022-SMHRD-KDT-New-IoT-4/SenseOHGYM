package com.example.senseohgym_h

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

class JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        val requestQueue = Volley.newRequestQueue(this)
        val etName = findViewById<EditText>(R.id.etName)
        val etJoinId = findViewById<EditText>(R.id.etJoinId)
        val etJoinPw = findViewById<EditText>(R.id.etJoinPw)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // 다음 버튼 누르면 JoinActivity2로 이동

        btnNext.setOnClickListener{
            val intent = Intent(this, JoinActivity2::class.java)
            var name = etName.text.toString()
            var id = etJoinId.text.toString()
            var pw = etJoinPw.text.toString()

            intent.putExtra("name", name)
            intent.putExtra("id", id)
            intent.putExtra("pw", pw)

            startActivity(intent)
        }
    }
}