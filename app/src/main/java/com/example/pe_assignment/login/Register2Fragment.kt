package com.example.pe_assignment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.pe_assignment.R


class Register2Fragment : Fragment() {
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSend = view.findViewById<Button>(R.id.register_btn2)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.register3Fragment)
        }

        val age = view.findViewById<TextView>(R.id.register_age_num)
        val minusbtn = view.findViewById<ImageButton>(R.id.register_age_minus)
        minusbtn.setOnClickListener {
                val gotage = Integer.parseInt(age.toString())
                val newage = gotage - 1
                age.text = newage.toString()
    }

        val addbtn = view.findViewById<ImageButton>(R.id.register_age_add)
        addbtn.setOnClickListener {
            val gotage = Integer.parseInt(age.toString())
            val newage = gotage + 1
            age.text = newage.toString()
        }
}}

