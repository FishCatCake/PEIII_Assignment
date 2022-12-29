package com.example.pe_assignment.hpv

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import androidx.navigation.findNavController
import com.example.pe_assignment.R

class HpvReminderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hpv_reminder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var btnSend2 = view.findViewById<ImageButton>(R.id.skip)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.vaccineCountdownFragment)
        }
        btnSend2 = view.findViewById<ImageButton>(R.id.back)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment3)
        }

        val reminderOn = view.findViewById<RadioButton>(R.id.reminder_on)

        val reminderOff = view.findViewById<RadioButton>(R.id.reminder_off)

        val btnSend = view.findViewById<Button>(R.id.done_btn)
        btnSend.setOnClickListener {
            val stateOn = reminderOn.isChecked
            Log.i("stateOn", stateOn.toString())

            val stateOff = reminderOff.isChecked
            Log.i("stateOff", stateOff.toString())
            if(stateOn)
            {
                val bundle = Bundle()
                bundle.putString("Status","On")
                Log.i("statusBef", bundle.toString())
                view.findNavController().navigate(R.id.vaccineCountdownFragment,bundle)
            }
            else
            {
                    view.findNavController().navigate(R.id.vaccineCountdownFragment)
            }

        }

    }
}