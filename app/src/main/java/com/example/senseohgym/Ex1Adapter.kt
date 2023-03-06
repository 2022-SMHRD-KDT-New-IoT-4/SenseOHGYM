package com.example.senseohgym

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Ex1Adapter(var context: Context, var data: ArrayList<Ex1VO>) :
    RecyclerView.Adapter<Ex1Adapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName1: TextView
        var tvIntro1: TextView
        var exImg1: ImageView

        init {
            tvName1 = view.findViewById(R.id.tvName1)
            tvIntro1 = view.findViewById(R.id.tvIntro1)
            exImg1 = view.findViewById(R.id.exImg1)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.ex1_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName1.text = data[position].name
        holder.tvIntro1.text = data[position].intro
        holder.exImg1.setImageResource(data[position].img)
    }


}