package com.example.pe_assignment.cycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.pe_assignment.R

class CycleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cycle, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSendPeriod = view.findViewById<ImageButton>(R.id.btn_add_period)
        val btnSendOtherData = view.findViewById<ImageButton>(R.id.btn_add_data1)
        val btnSendTemp = view.findViewById<ImageButton>(R.id.btn_add_data2)
        val btnSendHistory = view.findViewById<ImageButton>(R.id.btn_cycle_history)
        val btnBack = view.findViewById<ImageButton>(R.id.btn_back_cycle)

        btnSendPeriod.setOnClickListener {
            view.findNavController().navigate(R.id.cycleDetailFragment)
        }

        btnSendOtherData.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment)
        }
        btnSendTemp.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment) //to change
        }
        btnSendHistory.setOnClickListener{
            view.findNavController().navigate(R.id.cycleHistoryFragment)
        }

        btnBack.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }

    }
}