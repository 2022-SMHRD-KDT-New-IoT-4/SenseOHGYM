package com.example.senseohgym_h

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import com.android.volley.toolbox.Volley
import com.example.senseohgym_h.databinding.ActivityJoin2Binding

class JoinActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join2)

        val requestQueue = Volley.newRequestQueue(this)

        val etYear = findViewById<EditText>(R.id.etYear)
        val etMonth = findViewById<EditText>(R.id.etMonth)
        val etDate = findViewById<EditText>(R.id.etDate)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btnMemberJoin = findViewById<Button>(R.id.btnMemberJoin)
        val rg = findViewById<RadioGroup>(R.id.rg)



        var check = ""


        rg.setOnCheckedChangeListener{
            group, checkid ->
            if (checkid == R.id.chMan){
              check = "남자"
            }else{
                check = "여자"
            }
        }

        btnMemberJoin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            var year = etYear.text.toString()
            var month = etMonth.text.toString()
            var date = etDate.text.toString()
            var height = etHeight.text.toString()
            var weight = etWeight.text.toString()

            intent.putExtra("year", year)
            intent.putExtra("month", month)
            intent.putExtra("date", date)
            intent.putExtra("height", height)
            intent.putExtra("weight", weight)
            intent.putExtra("gender",check)

            startActivity(intent)


        }

    }
}