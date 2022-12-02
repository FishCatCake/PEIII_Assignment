package com.example.pe_assignment.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.pe_assignment.R


class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBack = view.findViewById<ImageButton>(R.id.btn_back_setting)
        val btnProfile = view.findViewById<ImageButton>(R.id.btn_profile)
        val cdLogOut = view.findViewById<CardView>(R.id.cd_log_out)
        btnBack.setOnClickListener{
            view.findNavController().navigate(R.id.homeFragment)
        }

        btnProfile.setOnClickListener{
            view.findNavController().navigate(R.id.cycleFragment)
        }

        cdLogOut.setOnClickListener{
            view.findNavController().navigate(R.id.loginActivity)
        }
    }

}