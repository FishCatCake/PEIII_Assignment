package com.example.pe_assignment.cycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView.OnDateChangeListener
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.login.RegisterViewModelFactory
import kotlinx.android.synthetic.main.activity_calendar.*
import com.example.pe_assignment.databinding.FragmentCycleBinding


class CycleFragment : Fragment() {
    private var binding: FragmentCycleBinding? = null
    private val sharedViewModel: CycleViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentCycleBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: CycleViewModel by activityViewModels() {
            CycleViewModelFactory((activity?.application as BaseApplication).repositoryCycle)
        }


        binding = fragmentBinding
        return fragmentBinding.root
        //return inflater.inflate(R.layout.fragment_cycle, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSendPeriod = view.findViewById<ImageButton>(R.id.btn_add_period)
        val btnSendOtherData = view.findViewById<ImageButton>(R.id.btn_add_data1)
        val btnSendTemp = view.findViewById<ImageButton>(R.id.btn_add_data2)
        val btnSendHistory = view.findViewById<ImageButton>(R.id.btn_cycle_history)
        val btnBack = view.findViewById<ImageButton>(R.id.btn_back_cycle)

        btnSendPeriod.setOnClickListener {
            view.findNavController().navigate(R.id.cycleDetailFragment)
        }

        btnSendOtherData.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment)
        }
        btnSendTemp.setOnClickListener{
            view.findNavController().navigate(R.id.selectionSymptonFragment) //to change
        }
        btnSendHistory.setOnClickListener{
            view.findNavController().navigate(R.id.cycleHistoryFragment)
        }

        btnBack.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }

        // binding
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            cycleViewModel = sharedViewModel
            cycleFragment = this@CycleFragment
        }

    }


    fun goToNextScreen() {

//        val account: String = binding?.userAccount?.text.toString()
//        val password: String = binding?.userPassword?.text.toString()
//        val passwordre: String = binding?.userPasswordre?.text.toString()
//        sharedViewModel.setAccount(account)
//        sharedViewModel.setPassword(password)
//        sharedViewModel.setPasswordRe(passwordre)
        //findNavController().navigate(R.id.action_register1Fragment_to_register2Fragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}