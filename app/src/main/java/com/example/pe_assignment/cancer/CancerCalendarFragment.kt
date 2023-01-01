package com.example.pe_assignment.cancer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCancerCanlendarBinding
import com.example.pe_assignment.databinding.FragmentCancerPhaseBinding

class CancerCalendarFragment : Fragment() {
    private var binding: FragmentCancerCanlendarBinding? = null
    private val sharedViewModel: CancerRecordViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentCancerCanlendarBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: CancerRecordViewModel by activityViewModels() {
            CancerRecordViewModelFactory((activity?.application as BaseApplication).repository_cancerrecord)
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
            myViewModel = sharedViewModel
            calendarFragment = this@CancerCalendarFragment
        }
        val calendarView: CalendarView = view.findViewById(R.id.calendarView3)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year
            sharedViewModel.setYear(year.toString())
            Log.i("year",year.toString())
            sharedViewModel.setMonth((month + 1).toString())
            Log.i("year",(month + 1).toString())
            sharedViewModel.setDate(dateOfMonth.toString())
            Log.i("year",dateOfMonth.toString())
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
        val btn_time = view.findViewById<Button>(R.id.btn_time)
        btn_time.setOnClickListener {
            view.findNavController().navigate(R.id.newTimelineActivity)
        }
        val btn_mycycle = view.findViewById<Button>(R.id.btn_mycycle)
        btn_mycycle.setOnClickListener {
            view.findNavController().navigate(R.id.menstruationActivity2)
        }
//        val btn_newrecord = view.findViewById<Button>(R.id.btn_cancer_record_new)
//        btn_newrecord.setOnClickListener {
//            view.findNavController().navigate(R.id.action_cancerCalendarFragment_to_cervicalCancerRecord01Fragment)
//        }
    }

    fun goToNextScreen() {
       findNavController().navigate(R.id.action_cancerCalendarFragment_to_cervicalCancerRecord01Fragment)
    }
}