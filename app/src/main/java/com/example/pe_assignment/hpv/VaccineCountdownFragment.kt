package com.example.pe_assignment.hpv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.pe_assignment.R


class VaccineCountdownFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vaccine_countdown, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnSend = view.findViewById<ImageButton>(R.id.right_arrow)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.testCountdownFragment)
        }

        btnSend = view.findViewById<ImageButton>(R.id.other)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvRecordFragment)
        }

        btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }
    }
}