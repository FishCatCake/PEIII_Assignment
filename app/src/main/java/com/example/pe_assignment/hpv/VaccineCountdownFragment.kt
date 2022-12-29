package com.example.pe_assignment.hpv

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.SwitchCompat
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

        val switch = view.findViewById<SwitchCompat>(R.id.vaccine_reminder)

        val bundle = arguments
        Log.i("budleAft", bundle.toString())
        if (bundle != null) {
            Log.i("statusAft",bundle.toString())
            switch.isChecked = true
        }


        var btnSend = view.findViewById<ImageButton>(R.id.right_arrow)
        btnSend.setOnClickListener {
            if(bundle != null)
            {
                val bundle2 = Bundle()
                bundle.putString("Status","On")
                Log.i("status", bundle2.toString())
                view.findNavController().navigate(R.id.testCountdownFragment,bundle2)
            }
            else
            {
                view.findNavController().navigate(R.id.testCountdownFragment)
            }
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