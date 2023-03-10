package com.example.senseohgym

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
// 회원페이지 - 운동정보 - 기구 사용횟수
class hyesuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hyesu)

        var index = 0

        class CustomBarEntry(
            x: Float,
            y: Float,
        ) : BarEntry(x, y)

// bar 데이터 생성
        val entries = listOf(
            CustomBarEntry(1f, 4f, ),
            CustomBarEntry(2f, 6f, ),
            CustomBarEntry(3f, 2f, ),
            CustomBarEntry(4f, 8f, ),
            CustomBarEntry(5f, 3f, ),
            CustomBarEntry(6f, 5f, ),
        )

// BarDataSet 생성 및 색상 지정
        val dataSet = BarDataSet(entries, "Bar Data")
        dataSet.color = ContextCompat.getColor(this, R.color.teal_700)


        // BarData 생성
        val data = BarData(dataSet)

        // HorizontalBarChart 설정
        val hyesuChart = findViewById<HorizontalBarChart>(R.id.hyesuChart)
        hyesuChart.data = data

        // bar 라벨 위치 설정
        val xAxis = hyesuChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.gridColor = Color.WHITE // 격자 색상이라는데..?
        xAxis.textColor = Color.WHITE

       // 간격설정...조정해도 잘린다.....
        xAxis.granularity = 1f
        xAxis.axisMinimum = 0f

        val leftAxis = hyesuChart.axisLeft
        leftAxis.setDrawGridLines(false)
        leftAxis.axisMinimum = 0f

        val yAxis = hyesuChart.axisRight
        yAxis.setTextColor(Color.WHITE)

        val lyAxis = hyesuChart.axisLeft
        lyAxis.setTextColor(Color.rgb(17, 35, 80))






        // bar 안에 표시되는 값의 위치와 글꼴 설정
        val valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                index = value.toInt()
                return  when (index){
                    4 -> "벤치 프레스"
                    6 -> "런닝머신"
                    2 -> "런닝머신"
                    8 -> "바벨"
                    3 -> "바벨"
                    5 -> "바벨"
                    else -> throw IndexOutOfBoundsException("index out")

                }
            }
        }

        val valueTextSize = 15f


        val valueTextColor = ContextCompat.getColor(this, R.color.white)

        dataSet.valueFormatter = valueFormatter
        dataSet.valueTextSize = valueTextSize
        dataSet.valueTextColor = valueTextColor

        // 입력값이 차트 위 or 이래에 그려질지
        hyesuChart.setDrawValueAboveBar(false)

        // 차트 최대 몇 개로 보여줄지 - 6개니까 7까지
        hyesuChart.setVisibleXRange(7F, 7F)


    }
}

