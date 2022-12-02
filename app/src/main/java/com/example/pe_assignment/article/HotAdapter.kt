package com.example.pe_assignment.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R

class HotAdapter(private val hotList : ArrayList<HotModel>):RecyclerView.Adapter<HotAdapter.HotViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_article_hot_item,
            parent,false)

        return HotViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: HotViewHolder, position: Int) {
        val currentItem = hotList[position]
        holder.hot.setImageResource(currentItem.imageSrc)

    }

    override fun getItemCount(): Int {
        return hotList.size
    }

    class HotViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val hot = itemView.findViewById<ImageButton>(R.id.article_btn)

    }
}