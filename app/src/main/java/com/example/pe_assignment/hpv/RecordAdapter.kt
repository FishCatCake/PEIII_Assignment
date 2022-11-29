package com.example.pe_assignment.hpv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R

class RecordAdapter(private val recordList : ArrayList<RecordModel>):RecyclerView.Adapter<RecordAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_hpv_record,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = recordList[position]
        holder.index.text = currentItem.index.toString()
        holder.brand.text = currentItem.brand.toString()
        holder.date.text = currentItem.date.toString()
    }

    override fun getItemCount(): Int {
        return recordList.size
    }
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val date = itemView.findViewById<TextView>(R.id.record_txt3)
        val index = itemView.findViewById<TextView>(R.id.record_txt1)
        val brand = itemView.findViewById<TextView>(R.id.record_txt2)
    }
}