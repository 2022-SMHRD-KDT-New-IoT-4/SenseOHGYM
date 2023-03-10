package com.example.senseohgym

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RevAdapter(var context: Context, var data: ArrayList<RevVo>) :
    RecyclerView.Adapter<RevAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var exer_name: TextView
        var rev_ox: TextView
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

    }


}