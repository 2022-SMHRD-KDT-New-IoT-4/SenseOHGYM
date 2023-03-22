package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast?.cancel()
            super.onBackPressed()
            finish() // 현재 액티비티 종료
            return
        } else {
            backToast = Toast.makeText(
                this,
                "한번 더 누르시면 앱이 종료됩니다.",
                Toast.LENGTH_SHORT
            )
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val member_reg = findViewById<ImageButton>(R.id.member_reg)
        val exer_reg = findViewById<ImageButton>(R.id.exer_reg)
        val MemberManage = findViewById<ImageButton>(R.id.MemberManage)

        val gym_name = intent.getStringExtra("gym_name")

        member_reg.setOnClickListener {
            val intent = Intent(this, MemberRegActivity::class.java)
            intent.putExtra("gym_name", gym_name)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        exer_reg.setOnClickListener {
            val exIntent = Intent(this, MachineDataActivity::class.java)
            exIntent.putExtra("gym_name", intent.getStringExtra("gym_name").toString())
            startActivity(exIntent)
        }
        MemberManage.setOnClickListener {
            val manageIntent = Intent(this, ManageActivity::class.java)
            manageIntent.putExtra("gym_name", intent.getStringExtra("gym_name").toString())
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(manageIntent)
        }
    }
}