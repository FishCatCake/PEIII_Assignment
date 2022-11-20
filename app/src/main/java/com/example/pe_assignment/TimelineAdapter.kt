package com.example.pe_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimelineAdapter(private val timeList : ArrayList<Timeline>):RecyclerView.Adapter<TimelineAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_timeline,
        parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = timeList[position]
        holder.title.text = currentItem.title.toString()
        holder.info.text = currentItem.info.toString()
        //holder.btn.text = currentItem.btn.toString()
        holder.date.text = currentItem.date.toString()
    }

    override fun getItemCount(): Int {
        return timeList.size
    }
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val date = itemView.findViewById<TextView>(R.id.timeline_date)
        //val line = itemView.findViewById<View>(R.id.timeline_line)
        val title = itemView.findViewById<TextView>(R.id.timeline_title)
        val info = itemView.findViewById<TextView>(R.id.timeline_information)
        //val btn = itemView.findViewById<Button>(R.id.timeline_btn)
    }
}