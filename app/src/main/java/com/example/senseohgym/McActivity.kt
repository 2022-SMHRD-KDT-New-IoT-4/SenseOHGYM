package com.example.senseohgym

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.mikephil.charting.charts.HorizontalBarChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import org.json.JSONArray
import org.json.JSONObject

// 회원페이지 - 운동정보 - 기구 사용횟수
// Mc = MachineCount
class McActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mc)

        queue = Volley.newRequestQueue(this)

        //mb_card가져오기
        val mb_card = intent.getStringExtra("mb_card")
        Log.d("카드번호 확인(McActivity) : ",mb_card.toString())
        // 장제원 url
        var url = "http://221.156.243.155:8081/Senseohgym/UserExercise_Toss.do"

        var index = 0
        request = object : StringRequest(
            Method.POST, url,
            {response ->
                Log.d("넘어온 값 확인 : ", response.toString()) //서버에서 넘어온 값 확인
                if(response.toString() == "운동정보를 보내기 위한 값들이 충분하지 않습니다."){
                    Toast.makeText(this,"값이 충분하지 않음!.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"운동정보받기 성공!", Toast.LENGTH_SHORT).show()
                    val response1 = JSONArray(response)

                }

            },
            {error ->
                Log.d("통신오류", error.printStackTrace().toString());
            }){
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params : MutableMap<String, String> = HashMap()

                params["mb_card"] = mb_card.toString()
                // btn_type 선언해주기. 왜? 서버쪽에서 ChatActivity와 McActivity 구별을 위해
                // ChatActivity는 0으로, McActivity는 1로 구별
                params["btn_type"] = "1";

                return params
            }
        }

        request.setShouldCache(false)
        queue.add(request)

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
        val mcChart = findViewById<HorizontalBarChart>(R.id.mcChart)
        mcChart.data = data

        // bar 라벨 위치 설정
        val xAxis = mcChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.gridColor = Color.WHITE // 격자 색상이라는데..?
        xAxis.textColor = Color.TRANSPARENT

       // 간격설정...조정해도 잘린다.....
        xAxis.granularity = 10f
        xAxis.axisMinimum = 0f

        val leftAxis = mcChart.axisLeft
        leftAxis.setDrawGridLines(false)
        leftAxis.axisMinimum = 0f
        leftAxis.textColor = Color.TRANSPARENT

        val yAxis = mcChart.axisRight
        yAxis.setTextColor(Color.WHITE)


        val lyAxis = mcChart.axisLeft
        lyAxis.setTextColor(Color.rgb(17, 35, 200),)

        val legend: Legend = mcChart.legend
        legend.isEnabled = false


        // bar 안에 표시되는 값의 위치와 글꼴 설정
        val valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                index = value.toInt()
                return  when (index){
                    4 -> "벤치 프레스"
                    6 -> "런닝머신"
                    2 -> "싸이클"
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
        mcChart.setDrawValueAboveBar(false)

        // 차트 최대 몇 개로 보여줄지 - 6개니까 7까지
        mcChart.setVisibleXRange(7F, 7F)


    }
}

