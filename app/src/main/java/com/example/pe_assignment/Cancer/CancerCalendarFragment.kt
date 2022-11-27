package com.example.pe_assignment.Cancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import androidx.navigation.findNavController
import com.example.pe_assignment.R
import kotlinx.android.synthetic.main.activity_calendar.*

class CancerCalendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cancer_canlendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val calendarView: CalendarView = view.findViewById(R.id.calendarView3)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year

            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
        val btn_time = view.findViewById<Button>(R.id.btn_time)
        btn_time.setOnClickListener {
            view.findNavController().navigate(R.id.cancerTimelineFragment)
        }

    }
}