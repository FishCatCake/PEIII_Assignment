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
import com.example.pe_assignment.databinding.FragmentCancerPhaseBinding



class CancerPhaseFragment : Fragment() {
        private var binding: FragmentCancerPhaseBinding? = null
        private val sharedViewModel: CancerUserViewModel by activityViewModels()
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            val fragmentBinding = FragmentCancerPhaseBinding.inflate(
                inflater, container, false
            )
            val sharedViewModel: CancerUserViewModel by activityViewModels() {
                CancerUserViewModelFactory((activity?.application as BaseApplication).repository_cancernew)
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
            cancernewFragment = this@CancerPhaseFragment
        }

        val btnskip = view.findViewById<ImageButton>(R.id.skip)
        btnskip.setOnClickListener {
            view.findNavController().navigate(R.id.cancerCalendarFragment)
        }
        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity2)
        }
    }

    fun goToNextScreen() {
        sharedViewModel.addNew()
        view?.findNavController()?.navigate(R.id.cancerCalendarFragment)
       }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}