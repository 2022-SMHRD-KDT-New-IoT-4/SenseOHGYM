package com.example.senseohgym

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONArray
import org.json.JSONObject

// 통신하는 코드 요청 (Volley 부분)
class ChartActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request: StringRequest
    private var time_list = ArrayList<BarEntry>()
    private var xArray = Array(7, { "" })

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        queue = Volley.newRequestQueue(this)

        // mb_card값 가져와서 Log로 값 잘나오는지 확인
        val mb_card = intent.getStringExtra("mb_card")
        Log.d("여기까지 오류 이상없음 : ", mb_card.toString())
        Log.d("카드번호 확인(ChartActivity) : ", mb_card.toString())

        // 장제원 url
        var url = "http://211.107.188.212:8081/Senseohgym/UserExercise_Toss.do"

        val barChart = findViewById<BarChart>(R.id.barchart)


        request = object : StringRequest(
            Method.POST, url,

            { response ->

                Log.d("확인 : ", response.toString())
                if (response.toString() == "운동정보를 보내기 위한 값들이 충분하지 않습니다.") {
                    Toast.makeText(this, "값이 충분하지 않음!.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "운동정보받기 성공!", Toast.LENGTH_SHORT).show()
                    //val response1 = JSONObject(response) --> Object형태여서 Array로바꿔줌
                    val response1 = JSONArray(response)
                    // parsing 예시. 필요하면 사용하려고 적어뒀음
                    // 0번째 값을 추출하기 위한 예시
                    // val jsonObject = response1.getJSONObject(0)
                    // val usetime = jsonObject.getString("rs_usetime")
                    // Log.d("0번째 사용시간 : ", usetime.toString())

                    val myHealth_list = ArrayList<myHealthVO>()


                    for (i in 0 until response1.length()) {
                        val myHealth = response1.getJSONObject(i)
                        myHealth_list.add(
                            myHealthVO(
                                myHealth.getInt("TOTAL_USETIME"),
                                myHealth.getString("REG_DATE_FORMATTED").substring(3)
                            )
                        )

                    }
                    for (i in 0 until myHealth_list.size) {
                        var y: Int = myHealth_list.get(i).total_usetime
                        var x: String = myHealth_list.get(i).reg_date_formatted

                        xArray[i] = x;

                        time_list.add(BarEntry(i.toFloat() + 1, y.toFloat()))

                        Log.d("time_list값", time_list.get(i).toString())

                    }
                    initBarChart(barChart)
                    setData(barChart)
                }
            },
            { error ->
                Log.d("통신오류", error.printStackTrace().toString());
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params: MutableMap<String, String> = HashMap()

                params["mb_card"] = mb_card.toString()
                // btn_type 선언해주기. 왜? 서버쪽에서 ChartActivity와 McActivity 구별을 위해
                // ChatActivity는 0으로, McActivity는 1로 구별
                params["btn_type"] = "0";
                return params
            }
        }

        request.setShouldCache(false)
        queue.add(request)
    }

    fun initBarChart(barChart: BarChart) {
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

        var index = 0
        xAxis.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                index = value.toInt()

                return when (index) {

                    1 -> xArray[0]
                    2 -> xArray[1]
                    3 -> xArray[2]
                    4 -> xArray[3]
                    5 -> xArray[4]
                    6 -> xArray[5]
                    7 -> xArray[6]

                    else -> throw IndexOutOfBoundsException("index out")

                } } }

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

    }

    fun setData(barChart: BarChart) {

        // Zoom In / Out 가능 여부 설정
        barChart.setScaleEnabled(false)
        val title = "3/10~3/15"

        val barDataSet = BarDataSet(time_list, title)
        // 바 색상 설정 (ColorTemplate.LIBERTY_COLORS)
        barDataSet.setColors(
            Color.rgb(231, 76, 60), Color.rgb(26, 188, 156),
            Color.rgb(241, 196, 15),
            Color.rgb(52, 152, 219), Color.rgb(163, 78, 198),
            Color.rgb(243, 156, 18), Color.rgb(75, 56, 234))

        val data = BarData(barDataSet)
        barChart.data = data

        barChart.setNoDataText("No chart to display")
        barChart.invalidate()
    }
}