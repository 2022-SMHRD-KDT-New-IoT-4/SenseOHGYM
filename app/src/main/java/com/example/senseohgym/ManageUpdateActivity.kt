package com.example.senseohgym

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ManageUpdateActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_update)


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
        val mbAge = intent.getStringExtra("age")
        val mbJoinDate = intent.getStringExtra("joindate")
        val gymName = intent.getStringExtra("gym_name")

        updateName.setText(mbName)
        updateCard.setText(mbCard)
        updateBirth.setText(mbBirth)
        updateHealth.setText(gymName)

//        updateAge.setText(mbAge)
//        updateName.setText(mbJoinDate)

        btnbtnUpdate.setOnClickListener {
            val intent = Intent(this, ManageActivity::class.java)



            startActivity(intent)
        }
        btnDelete.setOnClickListener {
            val intent = Intent(this, ManageActivity::class.java)



            startActivity(intent)
        }


    }
}