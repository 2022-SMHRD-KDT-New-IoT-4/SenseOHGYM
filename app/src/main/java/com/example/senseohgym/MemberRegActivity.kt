package com.example.senseohgym

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.android.volley.toolbox.Volley

class MemberRegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_reg)


        val requestQueue = Volley.newRequestQueue(this)

        val btnMemberJoin = findViewById<Button>(R.id.btnMemberJoin)
        val rg = findViewById<RadioGroup>(R.id.rg)
        val etCard = findViewById<EditText>(R.id.etCard)
        val etName = findViewById<EditText>(R.id.etName)
        val etGymName = findViewById<EditText>(R.id.etGymName)
        val etBirthday = findViewById<EditText>(R.id.etBitrhday)
        val etType = findViewById<EditText>(R.id.etType)




        var check = ""


        rg.setOnCheckedChangeListener{
                group, checkid ->
            if (checkid == R.id.chMan){
                check = "남"
            }else{
                check = "여"
            }
        }

        btnMemberJoin.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            val birthday = etBirthday.text.toString()
            val name = etName.text.toString()
            val gymName = etGymName.text.toString()
            val type = etType.text.toString()
            val card = etCard.text.toString()

            intent.putExtra("gender",check)
            intent.putExtra("birthday", birthday)
            intent.putExtra("name", name)
            intent.putExtra("gymName", gymName)
            intent.putExtra("type", type)
            intent.putExtra("card", card)


            startActivity(intent)


        }

    }
}