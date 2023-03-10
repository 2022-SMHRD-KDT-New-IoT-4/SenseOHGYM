package com.example.senseohgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class ManageUpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_update)

        val updateName = findViewById<TextView>(R.id.updateName)
        val updateCard = findViewById<TextView>(R.id.updateCard)
        val updateBirth = findViewById<TextView>(R.id.updateBirth)
        val updateHealth = findViewById<TextView>(R.id.updateHealth)
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