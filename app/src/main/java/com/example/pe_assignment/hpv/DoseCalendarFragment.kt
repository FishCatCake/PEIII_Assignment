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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentDoseCalendarBinding
import com.example.pe_assignment.databinding.FragmentReviewCalendarBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

class DoseCalendarFragment : Fragment() {

    private var binding: FragmentDoseCalendarBinding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentDoseCalendarBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: HpvViewModel by activityViewModels() {
            HpvViewModelFactory((activity?.application as BaseApplication).hpvrepository)
        }

        sharedViewModel.errorToast.observe(viewLifecycleOwner, Observer {
                hasError ->
            if(hasError == true){
                Toast.makeText(requireContext(), "Please choose the date", Toast.LENGTH_SHORT).show()
                sharedViewModel.donetoast()
            }
        })

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
            dose1CalendarFragment = this@DoseCalendarFragment
        }
        val calendarView: CalendarView = view.findViewById(R.id.hpv_first_dose)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year
            sharedViewModel.setDose1Year(year.toString())
            Log.i("year",year.toString())
            sharedViewModel.setDose1Month((month + 1).toString())
            Log.i("month",(month + 1).toString())
            sharedViewModel.setDose1Date(dateOfMonth.toString())
            Log.i("day",dateOfMonth.toString())
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }

        var btnSend2 = view.findViewById<ImageButton>(R.id.skip)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.doseCalendarFragment2)
        }
        btnSend2 = view.findViewById<ImageButton>(R.id.back)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.reviewCalendarFragment)
        }

    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_doseCalendarFragment_to_doseCalendarFragment2)
    }
}