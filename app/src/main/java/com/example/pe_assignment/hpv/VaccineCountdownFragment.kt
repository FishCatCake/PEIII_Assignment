package com.example.pe_assignment.hpv

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentTestCountdownBinding
import com.example.pe_assignment.databinding.FragmentVaccineCountdownBinding
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_test_countdown.*
import kotlinx.android.synthetic.main.fragment_vaccine_countdown.*
import java.time.LocalDate

class VaccineCountdownFragment : Fragment() {

    private var binding: FragmentVaccineCountdownBinding? = null
    private val sharedViewModel: HpvViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentVaccineCountdownBinding.inflate(
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
            vaccineViewModel = sharedViewModel
            vaccineCountdownFragment = this@VaccineCountdownFragment
        }

        val switch = view.findViewById<SwitchCompat>(R.id.vaccine_reminder)

        val bundle = arguments
        Log.i("budleAft", bundle.toString())
        if (bundle != null) {
            Log.i("statusAft",bundle.toString())
            switch.isChecked = true
        }

        val nyear = LocalDate.now().year
        val nmonth = LocalDate.now().monthValue
        val ndate = LocalDate.now().dayOfMonth

        var D1Y = sharedViewModel.dose1year.getValue().toString().toInt()
        var D1M = sharedViewModel.dose1month.getValue().toString().toInt()
        var D1D = sharedViewModel.dose1date.getValue().toString().toInt()

        val D1year = D1Y - nyear
        val D1month = D1M - nmonth
        val D1date = D1D - ndate
        var D1day = D1year * 365 + D1month * 30 + D1date

        var D2Y = sharedViewModel.dose2year.getValue().toString().toInt()
        var D2M = sharedViewModel.dose2month.getValue().toString().toInt()
        var D2D = sharedViewModel.dose2date.getValue().toString().toInt()

        val D2year = D2Y - nyear
        val D2month = D2M - nmonth
        val D2date = D2D - ndate
        var D2day = D2year * 365 + D2month * 30 + D2date

        var D3Y = sharedViewModel.dose3year.getValue().toString().toInt()
        var D3M = sharedViewModel.dose3month.getValue().toString().toInt()
        var D3D = sharedViewModel.dose3date.getValue().toString().toInt()

        val D3year = D3Y - nyear
        val D3month = D3M - nmonth
        val D3date = D3D - ndate
        var D3day = D3year * 365 + D3month * 30 + D3date

        if(D1day >= 0 && D2day > 0 && D3day > 0)
        {
            var hundred = D1day/100
            var ten = (D1day-hundred*100)/10
            var num = (D1day-hundred*100-ten*10)/1

            vaccine_hundred.text = hundred.toString()
            vaccine_ten.text = ten.toString()
            vaccine_num.text = num.toString()
        }
        if(D1day < 0 && D2day >= 0 && D3day >= 0)
        {
            var hundred = D2day/100
            var ten = (D2day-hundred*100)/10
            var num = (D2day-hundred*100-ten*10)/1

            vaccine_hundred.text = hundred.toString()
            vaccine_ten.text = ten.toString()
            vaccine_num.text = num.toString()
        }
        if(D1day < 0 && D2day < 0 && D3day >= 0)
        {
            var hundred = D3day/100
            var ten = (D3day-hundred*100)/10
            var num = (D3day-hundred*100-ten*10)/1

            vaccine_hundred.text = hundred.toString()
            vaccine_ten.text = ten.toString()
            vaccine_num.text = num.toString()
        }


        var btnSend = view.findViewById<ImageButton>(R.id.right_arrow)
        btnSend.setOnClickListener {
            if(bundle != null)
            {
                val bundle2 = Bundle()
                bundle.putString("Status","On")
                Log.i("status", bundle2.toString())
                view.findNavController().navigate(R.id.testCountdownFragment,bundle2)
            }
            else
            {
                view.findNavController().navigate(R.id.testCountdownFragment)
            }
        }

        btnSend = view.findViewById<ImageButton>(R.id.other)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvRecordFragment)
        }

        btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }
    }
}