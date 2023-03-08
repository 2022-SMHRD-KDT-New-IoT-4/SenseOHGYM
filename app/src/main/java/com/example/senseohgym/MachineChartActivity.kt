package com.example.senseohgym

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.HorizontalBarChart

class MachineChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_chart)

        val chart2 = findViewById<HorizontalBarChart>(R.id.barChart2)

    }
}

