package com.example.pe_assignment.cycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.pe_assignment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class CycleHistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cycle_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btnBack = view.findViewById<ImageButton>(R.id.btn_back_history)
        var btnDetail = view.findViewById<RelativeLayout>(R.id.cycle_record1)

        btnBack.setOnClickListener{
            view.findNavController().navigate(R.id.cycleFragment)
        }
        btnDetail.setOnClickListener{
            view.findNavController().navigate(R.id.cycleDetailFragment)
        }
    }
}