package com.example.assignment1_cloudfirebase.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment1_cloudfirebase.Model.Note_Item
import com.example.assignment1_cloudfirebase.R
import kotlinx.android.synthetic.main.item.view.*

class note_Adapter(var activity: Activity, var data:ArrayList<Note_Item>): RecyclerView.Adapter<note_Adapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName = itemView.tvName
        val tvdetailse = itemView.tvDetailse
        val tvchar = itemView.tvChar


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val root = LayoutInflater.from(activity).inflate(R.layout.item,parent,false)
        return MyViewHolder(root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = data[position].name
        holder.tvdetailse.text = data[position].details
        holder.tvchar.text = data[position].character.toString()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}