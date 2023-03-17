package com.example.senseohgym

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.senseohgym.manageAdapter as manageAdapter1


class manageAdapter(var context: Context, var data: ArrayList<manageVO>) :
    RecyclerView.Adapter<manageAdapter1.ViewHolder>() {
    var selectPos = -1

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mgName: TextView
        var mgCard: TextView
        var mgBirth: TextView
        var mgGender: TextView
        var mgJoinDate: TextView
        var LL: LinearLayout

        init {
            mgName = view.findViewById(R.id.mgName)
            mgCard = view.findViewById(R.id.mgCard)
            mgBirth = view.findViewById(R.id.mgBirth)
            mgGender = view.findViewById(R.id.mgGender)
            mgJoinDate = view.findViewById(R.id.mgJoinDate)
            LL = view.findViewById(R.id.LL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.manage_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mgName.text = data[position].name
        holder.mgCard.text = data[position].card
        holder.mgBirth.text = data[position].birth
        holder.mgGender.text = data[position].gender
        holder.mgJoinDate.text = data[position].joindate

        if (selectPos == position) {
            holder.LL.setBackgroundColor(Color.parseColor("#aaaaaa"))

            val intent = Intent(context, ManageUpdateActivity::class.java)

            intent.putExtra("name", holder.mgName.text.toString())
            intent.putExtra("card", holder.mgCard.text.toString())
            intent.putExtra("birth", holder.mgBirth.text.toString())
            intent.putExtra("gender", holder.mgGender.text.toString())
            intent.putExtra("joindate", holder.mgJoinDate.text.toString())
            intent.putExtra("gym_name", data[position].healthname)

            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
            (context as Activity).finish()
        } else {
            holder.LL.setBackgroundColor(Color.parseColor("#00ff0000"))
        }
        holder.LL.setOnClickListener {
            var beforePos = selectPos
            selectPos = position

            notifyItemChanged(beforePos)
            notifyItemChanged(selectPos)

        }
    }
}