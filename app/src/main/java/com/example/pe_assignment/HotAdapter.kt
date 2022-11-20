package com.example.pe_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HotAdapter(
    private val hotList: ArrayList<HotModel>
): RecyclerView.Adapter<HotAdapter.HotViewHolder>() {

    inner class HotViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        val hot: ImageView = itemView.findViewById<ImageView>(R.id.hot_article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : HotViewHolder {
        val parentView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_article_hot_item, parent, false)

        return HotViewHolder(parentView)
    }

    override fun onBindViewHolder(holder: HotViewHolder, position: Int) {
        val hotModel: HotModel = hotList.get(position)
        holder.hot.setImageResource(hotList[position].imageSrc)

    }

    override fun getItemCount(): Int {
        return hotList.size
    }}
