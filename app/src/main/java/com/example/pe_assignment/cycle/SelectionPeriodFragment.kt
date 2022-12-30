package com.example.pe_assignment.cycle

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
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentSelectionPeriodBinding

class SelectionPeriodFragment : Fragment() {
    private var binding: FragmentSelectionPeriodBinding? = null
    private val sharedViewModel: PeriodViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSelectionPeriodBinding.inflate(
            inflater, container, false
        )

        val sharedViewModel: PeriodViewModel by activityViewModels() {
            PeriodViewModelFactory((activity?.application as BaseApplication).repoPeriod)

        }

        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
                // gotoNext...
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
            periodSelectionFragment = this@SelectionPeriodFragment
        }

        val btnDone = view.findViewById<Button>(R.id.btn_done_period)

        btnDone.setOnClickListener{
            view.findNavController().navigate(R.id.cycleFragment)
        }
    }

}