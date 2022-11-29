package com.example.pe_assignment.article

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R

class CategoryAdapter(private val categoryList : ArrayList<CategoryModel>):RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_article_category_item,
            parent,false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem = categoryList[position]
        holder.title.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
    class CategoryViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.arti_cate)
    }
}