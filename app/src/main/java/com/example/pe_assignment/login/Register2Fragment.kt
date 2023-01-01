package com.example.pe_assignment.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentRegister2Binding

class Register2Fragment : Fragment() {
    private var binding: FragmentRegister2Binding? = null
    private val sharedViewModel: RegisterViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRegister2Binding.inflate(
            inflater,container, false
        )

        val sharedViewModel: RegisterViewModel by activityViewModels() {
            RegisterViewModelFactory((activity?.application as BaseApplication).repository)
        }

        sharedViewModel.errorToast.observe(viewLifecycleOwner, Observer { hasError ->  //Boolean
            if (hasError == true) {
                Toast.makeText(
                    requireContext(),
                    "Invalid inputs! Please fill all the fields with valid username/password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        sharedViewModel.navigateto.observe(
            viewLifecycleOwner,
            Observer { hasFinished ->  // if it is true
                if (hasFinished == true) {
                    goToNextScreen()
                    sharedViewModel.doneNavigating()
                }
            })

        sharedViewModel.errorToastUserName.observe(viewLifecycleOwner, Observer { userNameExist ->
            if (userNameExist == true) {
                Toast.makeText(
                    requireContext(),
                    "Username already exists. Please choose another username.",
                    Toast.LENGTH_SHORT
                ).show()
                sharedViewModel.donetoastUserName()
            }
        })

        binding = fragmentBinding
        return fragmentBinding.root
    }
    fun goToNextScreen() {
        val name: String = binding?.userName?.text.toString()
        val age: String = binding?.userAge?.text.toString()
        sharedViewModel.setName(name)
        sharedViewModel.setAge(age)
        sharedViewModel.register()
        findNavController().navigate(R.id.action_register2Fragment_to_register3Fragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            myViewModel = sharedViewModel
            register2Fragment = this@Register2Fragment
        }

//        val btnSend = view.findViewById<Button>(R.id.register_btn2)
//        btnSend.setOnClickListener {
//            view.findNavController().navigate(R.id.register3Fragment)
//        }

//        val age = view.findViewById<TextView>(R.id.register_age_num)
//        val minusbtn = view.findViewById<ImageButton>(R.id.register_age_minus)
//        minusbtn.setOnClickListener {
//            val gotage = Integer.parseInt(age.toString())
//            val newage = gotage - 1
//            age.text = newage.toString()
//        }
//
//        val addbtn = view.findViewById<ImageButton>(R.id.register_age_add)
//        addbtn.setOnClickListener {
//            val gotage = Integer.parseInt(age.toString())
//            val newage = gotage + 1
//            age.text = newage.toString()
//        }
    }
}
