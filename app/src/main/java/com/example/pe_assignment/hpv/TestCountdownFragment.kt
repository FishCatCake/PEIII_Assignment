package com.example.pe_assignment.hpv

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentTestCountdownBinding
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.fragment_test_countdown.*
import java.time.LocalDate
import java.util.*

class TestCountdownFragment : Fragment() {
    private var binding: FragmentTestCountdownBinding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentTestCountdownBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: HpvViewModel by activityViewModels() {
            HpvViewModelFactory((activity?.application as BaseApplication).hpvrepository)
        }
        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
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
            testViewModel = sharedViewModel
            testCountdownFragment = this@TestCountdownFragment
        }

        val switch = view.findViewById<SwitchCompat>(R.id.test_reminder)

        val bundle = arguments
        if (bundle != null) {
            Log.i("statusAft",bundle.toString())
            switch.isChecked = true
        }

        val nyear = LocalDate.now().year
        val nmonth = LocalDate.now().monthValue
        val ndate = LocalDate.now().dayOfMonth

        var reviewY = sharedViewModel.reviewyear.getValue().toString().toInt()
        var reviewM = sharedViewModel.reviewmonth.getValue().toString().toInt()
        var reviewD = sharedViewModel.reviewdate.getValue().toString().toInt()

        val year = reviewY - nyear
        val month = reviewM - nmonth
        val date = reviewD - ndate
        var day = year * 365 + month * 30 + date
        var hundred = day/100
        var ten = (day-hundred*100)/10
        var num = (day-hundred*100-ten*10)/1

        review_hundred.text = hundred.toString()
        review_ten.text = ten.toString()
        review_num.text = num.toString()

        var btnSend = view.findViewById<ImageButton>(R.id.other)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvRecordFragment)
        }
        btnSend = view.findViewById<ImageButton>(R.id.left_arrow)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.vaccineCountdownFragment)
        }
        btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.vaccineCountdownFragment)
        }
    }

}