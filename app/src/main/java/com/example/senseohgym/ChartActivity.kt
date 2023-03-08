package com.example.senseohgym

import android.graphics.Color
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        val barChart = findViewById<BarChart>(R.id.barchart)

        initBarChart(barChart)
        setData(barChart)

    }}

        private fun initBarChart(barChart: BarChart) {
            // 차트 회색 배경 설정 (default = false)
            barChart.setDrawGridBackground(false)
            // 막대 그림자 설정 (default = false)
            barChart.setDrawBarShadow(false)
            // 차트 테두리 설정 (default = false)
            barChart.setDrawBorders(false)

            val description = Description()
            // 오른쪽 하단 모서리 설명 레이블 텍스트 표시 (default = false)
            description.isEnabled = false
            barChart.description = description

            // X, Y 바의 애니메이션 효과
            barChart.animateY(1000)
            barChart.animateX(1000)

            // 바텀 좌표 값
            val xAxis: XAxis = barChart.xAxis
            // x축 위치 설정
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            // 그리드 선 수평 거리 설정
            xAxis.granularity = 1f
            // x축 텍스트 컬러 설정
            xAxis.textColor = Color.BLACK
            // x축 선 설정 (default = true)
            xAxis.setDrawAxisLine(false)
            // 격자선 설정 (default = true)
            xAxis.setDrawGridLines(false)

            val leftAxis: YAxis = barChart.axisLeft
            // 좌측 선 설정 (default = true)
            leftAxis.setDrawAxisLine(false)
            // 좌측 텍스트 컬러 설정
            leftAxis.textColor = Color.BLACK


//    val rightAxis: YAxis = barChart.axisRight
//    // 우측 선 설정 (default = true)
//    rightAxis.setDrawAxisLine(false)
//    // 우측 텍스트 컬러 설정
//    rightAxis.textColor = Color.BLACK


            // 바차트의 타이틀
            val legend: Legend = barChart.legend
            // 범례 모양 설정 (default = 정사각형)
            legend.form = Legend.LegendForm.LINE
            // 타이틀 텍스트 사이즈 설정
            legend.textSize = 15f
            // 타이틀 텍스트 컬러 설정
            legend.textColor = Color.BLACK
            // 범례 위치 설정
            legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
            legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER
            // 범례 방향 설정
            legend.orientation = Legend.LegendOrientation.HORIZONTAL
            // 차트 내부 범례 위치하게 함 (default = false)
            legend.setDrawInside(false)
        }

        private fun setData(barChart: BarChart) {

            // Zoom In / Out 가능 여부 설정
            barChart.setScaleEnabled(true)

            val valueList = ArrayList<BarEntry>()
            val title = "운동 시간"

            // 데이터 30분/60분 단위 /일주일 단위
            for (i in 1 until 7) {
                valueList.add(BarEntry(i.toFloat(), i * 10f))
            }

            val barDataSet = BarDataSet(valueList, title)
            // 바 색상 설정 (ColorTemplate.LIBERTY_COLORS)
            barDataSet.setColors(
                Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(136, 180, 187),
                Color.rgb(118, 174, 175), Color.rgb(42, 109, 130),Color.rgb(18, 42, 60))

            val data = BarData(barDataSet)
            barChart.data = data

            barChart.setNoDataText("No chart to display")
            barChart.invalidate()


        }