package com.example.pe_assignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import androidx.navigation.findNavController

class CancerTimelineCalendar : Fragment() {
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cancer_timeline_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        dateTV = view.findViewById(R.id.idTVDate)
//        calendarView = view.findViewById(R.id.calendarView)
//
//        // on below line we are adding set on
//        // date change listener for calendar view.
//        calendarView
//            .setOnDateChangeListener(
//                CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
//                    // In this Listener we are getting values
//                    // such as year, month and day of month
//                    // on below line we are creating a variable
//                    // in which we are adding all the variables in it.
//                    val Date = (dayOfMonth.toString() + "-"
//                            + (month + 1) + "-" + year)
//
//                    // set this date in TextView for Display
//                    dateTV.setText(Date)
//                })

        super.onViewCreated(view, savedInstanceState)
        val btnSend = view.findViewById<Button>(R.id.next_btn)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.timelineUploadFragment)
        }

        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.cancerTimelineFragment)
        }
    }

}
