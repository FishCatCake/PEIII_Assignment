package com.example.pe_assignment.cycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.login.RegisterViewModelFactory
import kotlinx.android.synthetic.main.activity_calendar.*
import com.example.pe_assignment.databinding.FragmentCycleBinding
import kotlinx.android.synthetic.main.activity_calendar.view.*
import java.util.*


class CycleFragment : Fragment() {
    private var binding: FragmentCycleBinding? = null
    private val sharedViewModel: PeriodViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCycleBinding.inflate(
            inflater, container, false
        )

        val sharedViewModel: PeriodViewModel by activityViewModels() {
            PeriodViewModelFactory((activity?.application as BaseApplication).repoPeriod)

        }

        binding = fragmentBinding
        return fragmentBinding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSendPeriod = view.findViewById<ImageButton>(R.id.btn_add_period)
        val btnSendOtherData = view.findViewById<ImageButton>(R.id.btn_add_data1)
        val btnSendTemp = view.findViewById<ImageButton>(R.id.btn_add_data2)
        val btnSendHistory = view.findViewById<ImageButton>(R.id.btn_cycle_history)
        val btnBack = view.findViewById<ImageButton>(R.id.btn_back_cycle)

        // calendar
        var calendarView : CalendarView = view.findViewById<CalendarView>(R.id.calendar_cycle)
        calendarView.setOnDateChangeListener { view, date, month, year
            sharedViewModel.setDate(inputDate = )

        }
        btnSendPeriod.setOnClickListener {
            view.findNavController().navigate(R.id.selectionPeriodFragment)
        }

        btnSendOtherData.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment)
        }
        btnSendTemp.setOnClickListener{
            view.findNavController().navigate(R.id.cycleTemperatureFragment) //to change
        }
        btnSendHistory.setOnClickListener{
            view.findNavController().navigate(R.id.cycleHistoryFragment)
        }

        btnBack.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }


//        // calendar
//        var calendarView = view.findViewById<CalendarView>(R.id.calendar_cycle)
//        var dateTV = view.findViewById<TextView>(R.id.idTVDate)
//
//        // on below line we are adding set on
//        // date change listener for calendar view.
//        calendarView.setOnDateChangeListener{ view, year, month, dayOfMonth ->
//            // Create calender object with which will have system date time.
//            val calender: Calendar = Calendar.getInstance()
//            // Set attributes in calender object as per selected date.
//            calender.set(year, month, dayOfMonth)
//            val Date = (dayOfMonth.toString() + "-"
//                            + (month + 1) + "-" + year)
//                    // set this date in TextView for Display
//                   dateTV.setText(Date)
//                }
        // binding
//        binding?.apply {
//            lifecycleOwner = viewLifecycleOwner
////            cycleViewModel = sharedViewModel
//            cycleFragment = this@CycleFragment
//        }

    }


//    fun goToNextScreen() {
//
////        val account: String = binding?.userAccount?.text.toString()
////        val password: String = binding?.userPassword?.text.toString()
////        val passwordre: String = binding?.userPasswordre?.text.toString()
////        sharedViewModel.setAccount(account)
////        sharedViewModel.setPassword(password)
////        sharedViewModel.setPasswordRe(passwordre)
//        //findNavController().navigate(R.id.action_register1Fragment_to_register2Fragment)
//    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        binding = null
//    }
}