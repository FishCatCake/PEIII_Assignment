package com.example.pe_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(
    private val attrList: ArrayList<ListModel>
): RecyclerView.Adapter<ListAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val attr = itemView.findViewById<TextView>(R.id.card_attr)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : CourseViewHolder {
        val parentView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return CourseViewHolder(parentView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val listModel: ListModel = attrList.get(position)
        holder.attr.text = listModel.title.toString()
    }

    override fun getItemCount(): Int {
        return attrList.size
    }

}
