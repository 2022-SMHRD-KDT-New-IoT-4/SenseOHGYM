package com.example.senseohgym

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class manageAdapter(var context: Context, var data: ArrayList<manageVO>) :
    RecyclerView.Adapter<manageAdapter.ViewHolder>() {
    
    lateinit var mgCheckBox: CheckBox

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mgName: TextView
        var mgCard: TextView
        var mgBirth: TextView
        var mgAge: TextView
        var mgJoinDate: TextView
        var mgCheck: CheckBox

        init {
            mgName = view.findViewById(R.id.mgName)
            mgCard = view.findViewById(R.id.mgCard)
            mgBirth = view.findViewById(R.id.mgBirth)
            mgAge = view.findViewById(R.id.mgAge)
            mgJoinDate = view.findViewById(R.id.mgJoinDate)
            mgCheck = view.findViewById(R.id.mgCheck)
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
        holder.mgAge.text = data[position].age
        holder.mgJoinDate.text = data[position].joindate
        


    }
}

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        var inflater = LayoutInflater.from(context)
//        var view = inflater.inflate(R.layout.ex1_list, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.tvName1.text = data[position].name
//        holder.tvIntro1.text = data[position].intro
//        holder.exImg1.setImageResource(data[position].img)
//    }
//}