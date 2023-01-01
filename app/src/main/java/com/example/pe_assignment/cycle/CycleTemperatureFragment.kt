package com.example.pe_assignment.cycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCycleTemperatureBinding

import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController


class CycleTemperatureFragment : Fragment() {

    private var binding: FragmentCycleTemperatureBinding? = null
    private val sharedViewModel: PeriodViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCycleTemperatureBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: PeriodViewModel by activityViewModels() {
            PeriodViewModelFactory((activity?.application as BaseApplication).repoPeriod)
        }

        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
                goToNextScreen()
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
            periodViewModel = sharedViewModel
            cycleTemperatureFragment = this@CycleTemperatureFragment
        }

    }

    fun goToNextScreen() {
        val temp: String = binding?.cycleTemp?.text.toString()
        sharedViewModel.setTemp(temp)
        sharedViewModel.insertAll()
        findNavController().navigate(R.id.cycleFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}