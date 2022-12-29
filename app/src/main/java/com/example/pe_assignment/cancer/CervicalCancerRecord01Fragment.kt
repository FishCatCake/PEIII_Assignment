package com.example.pe_assignment.cancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCancerCanlendarBinding
import com.example.pe_assignment.databinding.FragmentCervicalCancerRecord01Binding

class CervicalCancerRecord01Fragment : Fragment() {
    private var binding: FragmentCervicalCancerRecord01Binding? = null
    private val sharedViewModel: CancerRecordViewModel by activityViewModels()
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val fragmentBinding = FragmentCervicalCancerRecord01Binding.inflate(
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
            record1Fragment = this@CervicalCancerRecord01Fragment
        }

        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.action_cervicalCancerRecord01Fragment_to_cancerCalendarFragment)
        }
    }
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_cervicalCancerRecord01Fragment_to_cervicalCancerRecord02Fragment2)
    }
}