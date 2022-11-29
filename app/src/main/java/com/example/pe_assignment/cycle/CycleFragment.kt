package com.example.pe_assignment.cycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController
import com.example.pe_assignment.R

class CycleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_calendar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSend_period = view.findViewById<ImageButton>(R.id.btn_add_period)
        val btnSend_otherdata = view.findViewById<ImageButton>(R.id.btn_add_data1)
        val btnSend_temp = view.findViewById<ImageButton>(R.id.btn_add_data2)
        val btnSend_history = view.findViewById<ImageButton>(R.id.btn_cycle_history)

        btnSend_period.setOnClickListener {
            view.findNavController().navigate(R.id.cycleDetailFragment)
        }

        btnSend_otherdata.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment)
        }
        btnSend_temp.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment) //to change
        }
        btnSend_history.setOnClickListener{
            view.findNavController().navigate(R.id.cycleHistoryFragment)
        }
    }
}