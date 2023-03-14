package com.example.senseohgym

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import java.text.NumberFormat

// 기구 데이터 (관리자 페이지)
class MachineDataActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_data)

        val pieChart: PieChart = findViewById(R.id.piechart)
        pieChart.setExtraOffsets(40f, 0f, 40f, 0f)

        queue = Volley.newRequestQueue(this)

        val url = "http://211.107.188.212:8081/Senseohgym/Member_Login.do"

        request = StringRequest(
            Request.Method.POST, url,
            {response ->

            },
            {error ->
                Log.d("통신오류", error.printStackTrace().toString())
            }
        )

        class CustomPieEntry(
            x: Float,
            y: String
        ) : PieEntry(x, y)

        val entries = listOf(
            // 서버에서 보내준 값을 넣는 부분
            CustomPieEntry(40f, "런닝머신"),
            CustomPieEntry(10f, "바벨"),
            CustomPieEntry(10f, "싸이클"),
            CustomPieEntry(15f, "영이"),
            CustomPieEntry(10f, "솔"),
            CustomPieEntry(5f,"혜수"),
            CustomPieEntry(5f,"담희"),
            CustomPieEntry(5f,"윤한"),)

        // 차트 색상들

        val dataSet = PieDataSet(entries, "Pie Data")

        val colors = listOf(
            Color.parseColor("#4777c0"),
            Color.parseColor("#a374c6"),
            Color.parseColor("#4fb3e8"),
            Color.parseColor("#99cf43"),
            Color.parseColor("#fdc135"),
            Color.parseColor("#fd9a47"),
            Color.parseColor("#eb6e7a"),
            Color.parseColor("#6785c2"))
        dataSet.colors = colors
        dataSet.setValueTextColors(colors)

        // 값 선 크기..?
        dataSet.valueLinePart1Length = 0.6f
        dataSet.valueLinePart2Length = 0.3f
        dataSet.valueLineWidth = 2f
        dataSet.valueLinePart1OffsetPercentage = 115f  // Line starts outside of chart
        dataSet.isUsingSliceColorAsValueLineColor = true


        // 글자 사이즈
        dataSet.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
        dataSet.valueTextSize = 20f
        dataSet.valueTypeface = Typeface.DEFAULT_BOLD


        // Value formatting
        dataSet.valueFormatter = object : ValueFormatter() {
            private val formatter = NumberFormat.getPercentInstance()

            override fun getFormattedValue(value: Float) =
                formatter.format(value / 100f)
        }
        pieChart.setUsePercentValues(true)
        dataSet.selectionShift = 3f

        // Hole
        pieChart.isDrawHoleEnabled = true
        pieChart.holeRadius = 50f

        // 중앙 텍스트 스타일인데 변경하기 힘들 듯...
        pieChart.setDrawCenterText(true)
        pieChart.setCenterTextSize(20f)
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD)
        pieChart.setCenterTextColor(Color.parseColor("#FFFFFF"))
        pieChart.centerText = "기구 사용\n데이터"

        // 차트 안의 텍스트 스타일 변경...
        // val face = Typeface.createFromAsset(context.assets, "cute")
        // pieChart.setValueTypeface(face)

        // 차트 백그라운 변경
        //pieChart.setBackgroundColor(Color.parseColor("#112340"))

        // Disable legend & description
        pieChart.legend.isEnabled = false
        pieChart.description = null

        pieChart.data = PieData(dataSet)
        }

    }
