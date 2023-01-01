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
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentDoseCalendar2Binding
import com.example.pe_assignment.databinding.FragmentDoseCalendar3Binding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class DoseCalendarFragment3 : Fragment() {

    private var binding: FragmentDoseCalendar3Binding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDoseCalendar3Binding.inflate(
            inflater, container, false
        )
        val sharedViewModel: HpvViewModel by activityViewModels() {
            HpvViewModelFactory((activity?.application as BaseApplication).hpvrepository)
        }

        sharedViewModel.errorToast.observe(viewLifecycleOwner, Observer {
                hasError ->
            if(hasError == true){
                Toast.makeText(requireContext(), "Please choose the date", Toast.LENGTH_SHORT).show()
                goToFirstScreen()
                sharedViewModel.donetoast()
            }
        })

        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
                goToNextScreen()
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
            dose3CalendarFragment = this@DoseCalendarFragment3
        }
        val calendarView: CalendarView = view.findViewById(R.id.hpv_third_dose)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year
            sharedViewModel.setDose3Year(year.toString())
            Log.i("year",year.toString())
            sharedViewModel.setDose3Month((month + 1).toString())
            Log.i("month",(month + 1).toString())
            sharedViewModel.setDose3Date(dateOfMonth.toString())
            Log.i("day",dateOfMonth.toString())
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }

//        val btnSend = view.findViewById<Button>(R.id.next_btn3)
//        btnSend.setOnClickListener {
//            view.findNavController().navigate(R.id.hpvReminderFragment)
//        }
        var btnSend2 = view.findViewById<ImageButton>(R.id.skip)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.hpvReminderFragment)
        }
        btnSend2 = view.findViewById<ImageButton>(R.id.back)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment2)
        }

    }

    fun ReadData() {
        sharedViewModel.HPV()
    }

    fun goToNextScreen() {

        findNavController().navigate(R.id.action_doseCalendarFragment3_to_hpvReminderFragment)
    }

    fun goToFirstScreen() {

        findNavController().navigate(R.id.action_doseCalendarFragment3_to_reviewCalendarFragment)
    }
}