package com.example.senseohgym

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RevAdapter(var context: Context, var data: ArrayList<RevVo>, var mb_card : String) :
    RecyclerView.Adapter<RevAdapter.ViewHolder>() {

//    private lateinit var queue: RequestQueue
//    private lateinit var request: StringRequest

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



        holder.btn_rev.setOnClickListener {
            // 누르는데까지 문제없는가...?
//            Toast.makeText(context, "토스트 성공~ 성공~", Toast.LENGTH_SHORT).show()


            var intent = Intent(context, PopupActivity::class.java)
            intent.putExtra("mb_card",mb_card)
            Log.d("mb카드 번호 받음!! : ",mb_card.toString())
            intent.putExtra("exername", data.get(position).exer)
            Log.d("기구명 확인!! : : ",data.get(position).exer)


            // 액티비티처럼 화면이 돌아갈수 있게 해주는 코드
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            // 어댑터 파일은 액티비티가 아니라서 앞에 액티비티의 속성을 받아와서..
            // 스타트액티비티 명령어를 실행시킬 수 있음
            context.startActivity(intent)
        }


    }
}


