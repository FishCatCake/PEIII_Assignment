package com.example.pe_assignment.hpv

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentDoseCalendar2Binding
import com.example.pe_assignment.databinding.FragmentDoseCalendarBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class DoseCalendarFragment2 : Fragment() {

    private var binding: FragmentDoseCalendar2Binding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDoseCalendar2Binding.inflate(
            inflater, container, false
        )
        val sharedViewModel: HpvViewModel by activityViewModels() {
            HpvViewModelFactory((activity?.application as BaseApplication).hpvrepository)
        }
        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
//                    goToNextScreen()
                sharedViewModel.doneNavigating()
            }
        })

        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            hpvViewModel = sharedViewModel
            dose2CalendarFragment = this@DoseCalendarFragment2
        }
        val calendarView: CalendarView = view.findViewById(R.id.hpv_second_dose)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year
            sharedViewModel.setDose2Year(year.toString())
            Log.i("year",year.toString())
            sharedViewModel.setDose2Month((month + 1).toString())
            Log.i("month",(month + 1).toString())
            sharedViewModel.setDose2Date(dateOfMonth.toString())
            Log.i("day",dateOfMonth.toString())
        }
//        val btnSend = view.findViewById<Button>(R.id.next_btn2)
//        btnSend.setOnClickListener {
//            view.findNavController().navigate(R.id.doseCalendarFragment3)
//        }
        var btnSend2 = view.findViewById<ImageButton>(R.id.skip)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment3)
        }
        btnSend2 = view.findViewById<ImageButton>(R.id.back)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment)
        }

    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_doseCalendarFragment2_to_doseCalendarFragment3)
    }
}