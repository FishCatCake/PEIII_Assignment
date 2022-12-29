package com.example.pe_assignment.hpv

import android.content.SharedPreferences
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
import kotlinx.android.synthetic.main.fragment_article.*

class TestCountdownFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_countdown, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switch = view.findViewById<SwitchCompat>(R.id.test_reminder)

        val bundle = arguments
        if (bundle != null) {
            Log.i("statusAft",bundle.toString())
            switch.isChecked = true
        }

        var btnSend = view.findViewById<ImageButton>(R.id.other)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvRecordFragment)
        }
        btnSend = view.findViewById<ImageButton>(R.id.left_arrow)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.vaccineCountdownFragment)
        }
        btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.vaccineCountdownFragment)
        }
    }

}