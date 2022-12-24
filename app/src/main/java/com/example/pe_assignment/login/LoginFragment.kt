package com.example.pe_assignment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.example.pe_assignment.R

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registertextview = view.findViewById<TextView>(R.id.register_textview)
        val btnSignIn =  view.findViewById<Button>(R.id.btn_sign_in)

        registertextview.setOnClickListener {
            view.findNavController().navigate(R.id.register1Fragment)
        }
        btnSignIn.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }
    }




}