package com.example.pe_assignment.hpv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R

class ImageAdapter(private val imageList : ArrayList<ImageModel>):RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.article_image_item,
            parent,false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.image.setImageResource(currentItem.imageSrc)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
    class ImageViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.article_image)
    }
}