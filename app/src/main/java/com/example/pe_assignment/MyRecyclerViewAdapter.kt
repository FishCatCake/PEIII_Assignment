package com.example.pe_assignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.database.entity.User
import com.example.pe_assignment.databinding.UserInfoItemBinding


class MyRecycleViewAdapter(private val usersList :List<User>)
    : RecyclerView.Adapter<MyviewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: UserInfoItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.user_info_item,parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.bind(usersList[position])
    }
}

class MyviewHolder(private val binding :UserInfoItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(user : User){
        binding.accountTextView.text = user.account
//        binding.nameTextView.text = user.name
//        binding.ageTextView.text = user.age.toString()
    }

}