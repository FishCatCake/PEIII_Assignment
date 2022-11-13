package com.example.pe_assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter (
    private val categoryList: ArrayList<CategoryModel>
    ): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

        inner class CategoryViewHolder(itemView: View):
            RecyclerView.ViewHolder(itemView) {
            val category = itemView.findViewById<TextView>(R.id.arti_cate)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                : CategoryViewHolder {
            val parentView = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_article_category_item, parent, false)

            return CategoryViewHolder(parentView)
        }

        override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            val categoryModel: CategoryModel = categoryList.get(position)
            holder.category.text = categoryModel.title.toString()

        }

        override fun getItemCount(): Int {
            return categoryList.size
        }
}