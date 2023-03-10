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
    xAxis.textColor = Color.WHITE
    // x축 선 설정 (default = true)
    xAxis.setDrawAxisLine(false)
    // 격자선 설정 (default = true)
    xAxis.setDrawGridLines(false)

    val leftAxis: YAxis = barChart.axisLeft
    // 좌측 선 설정 (default = true)
    leftAxis.setDrawAxisLine(false)
    // 좌측 텍스트 컬러 설정
    leftAxis.textColor = Color.WHITE


    val rightAxis: YAxis = barChart.axisRight
    // 우측 선 설정 (default = true)
    rightAxis.setDrawAxisLine(false)
    // 우측 텍스트 컬러 설정
    rightAxis.textColor = Color.TRANSPARENT
    leftAxis.textColor = Color.WHITE


    // 바차트의 설정
    val legend: Legend = barChart.legend
    // 범례 모양 설정 (default = 정사각형)
    legend.form = Legend.LegendForm.NONE

    // 타이틀 텍스트 사이즈 설정
    legend.textSize = 30f
    // 타이틀 텍스트 컬러 설정
    legend.textColor = Color.WHITE
    // 범례 위치 설정
    legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
    legend.horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER


    // 밑에 쪼그마한 이상한 거(범례) 없애기
    // legend.isEnabled = false

}

private fun setData(barChart: BarChart) {

    // Zoom In / Out 가능 여부 설정
    barChart.setScaleEnabled(false)

    val valueList = ArrayList<BarEntry>()
    val title = "3/3~3/10"

    // 데이터 30분/60분 단위 /일주일 단위
    for (i in 1 until 7) {
        valueList.add(BarEntry(i.toFloat(), i * 10f))
    }

    val barDataSet = BarDataSet(valueList, title)
    // 바 색상 설정 (ColorTemplate.LIBERTY_COLORS)
    barDataSet.setColors(
        Color.rgb(231, 76, 60), Color.rgb(26, 188, 156), Color.rgb(241, 196, 15),
        Color.rgb(52, 152, 219), Color.rgb(163, 78, 198),Color.rgb(234, 156, 18))

    val data = BarData(barDataSet)
    barChart.data = data

    barChart.setNoDataText("No chart to display")
    barChart.invalidate()


}