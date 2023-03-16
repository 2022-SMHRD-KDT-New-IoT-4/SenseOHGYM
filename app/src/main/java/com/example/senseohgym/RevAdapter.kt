package com.example.senseohgym

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.AuthFailureError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RevAdapter(var context: Context, var data: ArrayList<RevVo>, var mb_card: String) :
    RecyclerView.Adapter<RevAdapter.ViewHolder>() {

    private var queue = Volley.newRequestQueue(context)
    private lateinit var request: StringRequest

    private lateinit var exer_name: TextView
    private lateinit var rev_ox: TextView // 예약여부

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var exer_name: TextView
        var rev_ox: TextView // 예약여부
        var btn_rev: Button

        init {
            exer_name = view.findViewById(R.id.exer_name)
            rev_ox = view.findViewById(R.id.rev_ox)
            btn_rev = view.findViewById(R.id.btn_rev)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.rev_list, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.exer_name.text = data[position].exer
        holder.rev_ox.text = data[position].rev

        var url = "http://211.107.188.212:8081/Senseohgym/Member_Login.do"
        // 요청 보낼 프로그램 주소 만들기
        // 기구 이름 빼서 그 기구이름으로 된 예약정보가 있는지 확인 후
        // 있으면 1 보내주고 없으면 0 보내주기

        request = object : StringRequest(
            Method.POST, url,
            { response ->
                // 1 or 0
                Log.d("결과", response.toString())
                if (response.toInt() == 1) {
                    // 예약있음 -> 예약불가
                    holder.rev_ox.text = "예약불가"
                }
            },
            { error ->
                Log.d("통신오류", error.printStackTrace().toString());
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String, String>? {
                val params: MutableMap<String, String> = HashMap()

                params["exer_name"] = holder.exer_name.toString()

                return params
            }
        }

        holder.btn_rev.setOnClickListener {
            // 누르는데까지 문제없는가...?
//            Toast.makeText(context, "토스트 성공~ 성공~", Toast.LENGTH_SHORT).show()
            var intent = Intent(context, PopupActivity::class.java)
            intent.putExtra("mb_card", mb_card)
            Log.d("mb카드 번호 받음!! : ", mb_card.toString())
            intent.putExtra("exername", data.get(position).exer)
            Log.d("기구명 확인!! : : ", data.get(position).exer)
            // 액티비티처럼 화면이 돌아갈수 있게 해주는 코드
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            // 어댑터 파일은 액티비티가 아니라서 앞에 액티비티의 속성을 받아와서..
            // 스타트액티비티 명령어를 실행시킬 수 있음
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }
}


