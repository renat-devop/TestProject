package com.example.testproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.data.TestData

class RecViewAdapter(var list: List<TestData>): RecyclerView.Adapter<RecViewAdapter.MyViewHolder>()  {
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById(R.id.text_view_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = list[position].nameCafe
    }

    override fun getItemCount(): Int = list.size
}