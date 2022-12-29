package com.example.pe_assignment.cancer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCancerCanlendarBinding
import com.example.pe_assignment.databinding.FragmentCancerTimelineCalendarBinding

class CancerTimelineCalendar : Fragment() {
    private var binding: FragmentCancerTimelineCalendarBinding? = null
    private val sharedViewModel: CancerTimelineViewModel by activityViewModels()
    lateinit var calendarView: CalendarView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentCancerTimelineCalendarBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: CancerTimelineViewModel by activityViewModels() {
            CancerTimelineViewModelFactory((activity?.application as BaseApplication).repository_cancertimeline)
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
            timecalFragment = this@CancerTimelineCalendar
        }
        val calendarView: CalendarView = view.findViewById(R.id.calendarView)
        calendarView.setOnDateChangeListener { view, year, month, dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month + 1) + "/ " + year
            sharedViewModel.setYear(year.toString())
            Log.i("year2",year.toString())
            sharedViewModel.setMonth((month + 1).toString())
            Log.i("year2",(month + 1).toString())
            sharedViewModel.setDate(dateOfMonth.toString())
            Log.i("year2",dateOfMonth.toString())
            //Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }

        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.cancerTimelineFragment3)
        }
    }
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_cancerTimelineCalendar_to_timelineUploadFragment)
    }

}
