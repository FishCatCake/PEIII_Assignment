package com.example.pe_assignment.hpv

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentReviewCalendarBinding
import androidx.lifecycle.Observer
import androidx.navigation.findNavController

class ReviewCalendarFragment : Fragment() {
    private var binding: FragmentReviewCalendarBinding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentReviewCalendarBinding.inflate(
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
            reviewCalendarFragment = this@ReviewCalendarFragment
        }
        val calendarView: CalendarView = view.findViewById(R.id.calendarView3)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year
            sharedViewModel.setReviewYear(year.toString())
            Log.i("year",year.toString())
            sharedViewModel.setReviewMonth((month + 1).toString())
            Log.i("year",(month + 1).toString())
            sharedViewModel.setReviewDate(dateOfMonth.toString())
            Log.i("year",dateOfMonth.toString())
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
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

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_reviewCalendarFragment_to_doseCalendarFragment)
    }
}