package com.example.pe_assignment.cancer

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCancerTimelineCalendarBinding
import com.example.pe_assignment.databinding.FragmentTimelineinfoboardBinding
import kotlinx.android.synthetic.main.fragment_timelineinfoboard.*
import java.time.LocalDate
import java.util.*

class TimelineinfoboardFragment : Fragment() {
    private var binding: FragmentTimelineinfoboardBinding? = null
    private val sharedViewModel: CancerTimelineViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentTimelineinfoboardBinding.inflate(
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            myViewModel = sharedViewModel
            infoFragment = this@TimelineinfoboardFragment
        }
        val nyear = LocalDate.now().year
        val nmonth = LocalDate.now().monthValue
        val ndate = LocalDate.now().dayOfMonth

//        var byear = (sharedViewModel.year.value.toString()).toInt()
//       var bmonth = (sharedViewModel.month.toString()).toInt()
//        var bdate = (sharedViewModel.date.toString()).toInt()
        var ddd = sharedViewModel.date.getValue().toString().toInt()


        var day = ndate - ddd

        time_res_desc.text = day.toString() + " days"

        val btnSend = view.findViewById<Button>(R.id.next_btn)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.cancerTimelineFragment3)
        }
        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.cervicalCancerTimeline02fragment3)
        }
    }


}