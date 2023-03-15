
package com.example.senseohgym

import android.graphics.Color
import android.os.Bundle
import android.security.identity.CredentialDataResult.Entries
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

// 회원페이지 - 운동정보 - 기구 사용횟수
// Mc = MachineCount
class McActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request : StringRequest
    //private lateinit var xArray : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mc)

        queue = Volley.newRequestQueue(this)

        //mb_card가져오기
        val mb_card = intent.getStringExtra("mb_card")
        Log.d("카드번호 확인(McActivity) : ",mb_card.toString())
        // 장제원 url
        var url = "http://211.107.188.212:8081/Senseohgym/UserExercise_Toss.do"


        request = object : StringRequest(
            Method.POST, url,
            {response ->
                Log.d("확인", response.toString()) //서버에서 넘어온 값 확인
                if(response.toString() == "운동정보를 보내기 위한 값들이 충분하지 않습니다."){
                    Toast.makeText(this,"값이 충분하지 않음!.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"운동정보받기 성공!", Toast.LENGTH_SHORT).show()
                    val response1 = JSONArray(response)

                    class CustomBarEntry(
                        y: Float,
                        x: Float,
                    ) : BarEntry(x, y)

                    val mc_list = ArrayList<McVO>()

                    for(i in 0 until response1.length()){
                        val mc = response1.getJSONObject(i)
                        mc_list.add(
                            McVO(
                                mc.getString("rev_machine"),
                                mc.getInt("machine_count")
                        ))
                    }
                    Log.d("mc_list 확인", mc_list.size.toString())
                    var xArray = mutableListOf<String>()
                    val entries = mutableListOf<CustomBarEntry>()
                    for(i in 0 until mc_list.size){

                        var x : Float = mc_list.get(i).machine_count.toFloat()
                        xArray.add(mc_list.get(i).rev_machine)
                        Log.d("기구이름 확인", xArray.get(i))

                        entries.add(CustomBarEntry(i.toFloat() + 1, x))
                        Log.d("Entries 확인", entries[i].toString())
                    }
//                    val entries = listOf(
//                        CustomBarEntry(1f, 3f, ),
//
//                    )

                    // BarDataSet 생성 및 색상 지정
                    val dataSet = BarDataSet(entries as List<BarEntry>?, "Bar Data")
                    dataSet.setColors(
                        Color.rgb(231, 76, 60), Color.rgb(26, 188, 156),
                        Color.rgb(241, 196, 15),
                        Color.rgb(52, 152, 219),
                       )


                    // BarData 생성
                    val data = BarData(dataSet)

                    // HorizontalBarChart 설정
                    val mcChart = findViewById<HorizontalBarChart>(R.id.mcChart)
                    mcChart.data = data

                    // bar 라벨 위치 설정
                    val xAxis = mcChart.xAxis
                    xAxis.position = XAxis.XAxisPosition.BOTTOM
                    xAxis.setDrawGridLines(false) // 격자구조
                    xAxis.gridColor = Color.WHITE // 격자 색상이라는데..?
                    xAxis.textColor = Color.TRANSPARENT

                    // 간격설정...조정해도 잘린다.....
                    xAxis.granularity = 1f
                    xAxis.axisMinimum = 0f

                    val leftAxis = mcChart.axisLeft
                    leftAxis.setDrawGridLines(false)
                    leftAxis.axisMinimum = 0f
                    leftAxis.textColor = Color.TRANSPARENT

                    val yAxis = mcChart.axisRight
                    yAxis.setDrawGridLines(false)
                    yAxis.setTextColor(Color.WHITE)

                    // 아래 축 최소 최대 값
                    yAxis.axisMinimum = 1f
                    yAxis.axisMaximum = 3f

                    val lyAxis = mcChart.axisLeft
                    //lyAxis.setTextColor(Color.rgb(17, 35, 200),)

                    val legend: Legend = mcChart.legend
                    legend.isEnabled = false


                    // bar 안에 표시되는 값의 위치와 글꼴 설정

                    Log.d("여기확인", xArray.toString())



                    var index = 0
                    val valueFormatter = object : ValueFormatter() {
                        override fun getFormattedValue(value: Float): String {
                            index = value.toInt()

                            Log.d("도착확인2", "도착")
                            Log.d("값확인", value.toString())

                            return when (index){

                                1 -> xArray[0]
                                2 -> xArray[1]
                                3 -> xArray[2]
                                4 -> xArray[3]

//                                1 -> "벤치 프레스"
//                                2 -> xArray[0]
//                                3 -> xArray[1]
//                                4 -> "바벨"
//                                5 -> "바벨"
//                                6 -> "바벨"
                                else -> throw IndexOutOfBoundsException("index out")


                            }
                        }
                    }

                    val valueTextSize = 15f


                    val valueTextColor = ContextCompat.getColor(this, R.color.white)

                    Log.d("도착확인4", "여기")

                    dataSet.valueFormatter = valueFormatter
                    dataSet.valueTextSize = valueTextSize
                    dataSet.valueTextColor = valueTextColor

                    // 입력값이 차트 위 or 이래에 그려질지
                    mcChart.setDrawValueAboveBar(false)

                    // 차트 최대 몇 개로 보여줄지 - 6개니까 7까지
                    mcChart.setVisibleXRange(7F, 7F)

                    mcChart.invalidate()

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
                params["btn_type"] = "1"

                return params
            }
        }

        request.setShouldCache(false)
        queue.add(request)



// bar 데이터 생성



    }
}
