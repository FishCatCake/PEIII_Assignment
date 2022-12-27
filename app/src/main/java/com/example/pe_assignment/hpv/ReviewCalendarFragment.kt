package com.example.pe_assignment.hpv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentRegister1Binding
import com.example.pe_assignment.databinding.FragmentReviewCalendarBinding
import com.example.pe_assignment.login.RegisterViewModel
import java.text.SimpleDateFormat
import java.util.*

class ReviewCalendarFragment : Fragment() {
    private var binding: FragmentReviewCalendarBinding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_calendar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val calendarView: CalendarView = view.findViewById(R.id.calendarView)
        val date = view.findViewById<TextView>(R.id.review_date)

        calendarView.setOnDateChangeListener{ view,year,month,dateOfMonth ->
            val todayDate = "Selected Date: " + dateOfMonth + "/ " + (month+1) + "/ " +year
            date.setText(todayDate)
        }

        var btnSend = view.findViewById<Button>(R.id.next_btn)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment)
        }
        var btnSend2 = view.findViewById<ImageButton>(R.id.skip)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment)
        }

        btnSend2 = view.findViewById<ImageButton>(R.id.back)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }

    }

//    fun goToNextScreen() {
//        val reviewDate: String? = binding?.reviewDate?.text.toString()
//
//        sharedViewModel.setReviewDate(reviewDate)
//        findNavController().navigate(R.id.action_reviewCalendarFragment_to_doseCalendarFragment)
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}