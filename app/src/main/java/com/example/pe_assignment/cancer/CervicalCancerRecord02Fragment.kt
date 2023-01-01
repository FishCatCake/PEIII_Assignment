package com.example.pe_assignment.cancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCervicalCancerRecord01Binding
import com.example.pe_assignment.databinding.FragmentCervicalCancerRecord02Binding

class CervicalCancerRecord02Fragment : Fragment() {
    private var binding: FragmentCervicalCancerRecord02Binding? = null
    private val sharedViewModel: CancerRecordViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCervicalCancerRecord02Binding.inflate(
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
            record2Fragment = this@CervicalCancerRecord02Fragment
        }

        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.cervicalCancerRecord01Fragment)
        }
    }

    fun goToOhter(){
        findNavController().navigate(R.id.action_cervicalCancerRecord02Fragment_to_cervicalCancerRecord03Fragment2)
    }
    fun goToNextScreen() {
        sharedViewModel.addRecord()
        findNavController().navigate(R.id.action_cervicalCancerRecord02Fragment_to_cancerCalendarFragment)
    }
}