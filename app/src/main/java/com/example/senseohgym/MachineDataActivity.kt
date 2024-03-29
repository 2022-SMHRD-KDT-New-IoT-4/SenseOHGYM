package com.example.senseohgym

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.textclassifier.TextClassificationSessionId
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.coroutines.yield
import org.json.JSONArray
import java.text.NumberFormat


// 기구 데이터 (관리자 페이지)
class MachineDataActivity : AppCompatActivity() {

    private lateinit var queue: RequestQueue
    private lateinit var request: StringRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_machine_data)

        val gym_name = intent.getStringExtra("gym_name").toString()

        val pieChart: PieChart = findViewById(R.id.piechart)
        pieChart.setExtraOffsets(30f, 0f, 45f, 0f)

        queue = Volley.newRequestQueue(this)

        val url = "http://211.107.188.212:8081/Senseohgym/Admin_ExerciseCheck.do"

        request = object : StringRequest(
            Request.Method.POST, url,
            { response ->
                Log.d("운동정보 결과", response.toString())
                val result = JSONArray(response)

                class Chart(
                    x: Float,
                    y: String
                ) : PieEntry(x, y)

                val machine_list = ArrayList<machineVO>()
                var machineList = mutableListOf<Chart>()
                var sum: Int = 0



                for (i in 0 until result.length()) {
                    val machine = result.getJSONObject(i)
                    machine_list.add(
                        machineVO(
                            machine.getString("rev_machine"),
                            machine.getInt("machine_count")

                        )
                    )
                    sum += machine.getInt("machine_count")
                    Log.d("sum Check", sum.toString())
                }


                for (i in 0 until machine_list.size) {
                    var y: String = machine_list.get(i).rev_machine
                    var x: Float
                    var count = machine_list.get(i).machine_count.toInt()
                    x = (count * 100 / sum).toFloat()
                    Log.d("x확인", x.toString())
                    machineList.add(Chart(x, y))
                }
                Log.d("size : ", machineList.size.toString())
                Log.d("data", machineList.get(0).x.toString())

                // 차트 색상들

                val dataSet = PieDataSet(machineList as List<PieEntry>?, "Pie Data")

                val colors = listOf(
                    Color.parseColor("#4777c0"),
                    Color.parseColor("#a374c6"),
                    Color.parseColor("#99cf43"),
                    Color.parseColor("#fdc135"),
                    Color.parseColor("#fd9a47"),
                    Color.parseColor("#eb6e7a"),
                    Color.parseColor("#6785c2")
                )
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

                // 파이 차트 길이, 넓이
                pieChart.minimumWidth = 1200
                pieChart.minimumHeight = 1200


                pieChart.setEntryLabelTextSize(20f);



                // Hole
                pieChart.isDrawHoleEnabled = false


                // 이것은 숫자 텍스트 사이즈
                dataSet.setValueTextSize(20f)




                // Disable legend & description
                pieChart.legend.isEnabled = false
                pieChart.description = null

                pieChart.data = PieData(dataSet)

                // 운동기구 갯수는 result.length() 를 사용
                Log.d("운동기구이름", result.getJSONObject(0).getString("rev_machine"))
                Log.d("사용횟수", result.getJSONObject(0).getString("machine_count"))

            },
            { error ->
                Log.d("통신오류", error.printStackTrace().toString())
            }
        ) {
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params: MutableMap<String, String> = HashMap()

                params["gym_name"] = gym_name

                return params
            }
        }
        request.setShouldCache(false)
        queue.add(request)
    }

}

