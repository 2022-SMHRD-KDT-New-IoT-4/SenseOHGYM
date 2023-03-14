package com.example.senseohgym

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ManageUpdateActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
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
        val btnbtnDelete = findViewById<Button>(R.id.btnbtnDelete)

        btnbtnUpdate.setOnClickListener {

        }
        btnbtnDelete.setOnClickListener{

        }



    }
}