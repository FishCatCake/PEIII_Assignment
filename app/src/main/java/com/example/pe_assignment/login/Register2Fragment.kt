package com.example.pe_assignment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
//import com.example.pe_assignment.databinding.FragmentRegister2Binding


//class Register2Fragment : Fragment() {
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding: FragmentRegister2Binding = DataBindingUtil.inflate(
//            inflater,
//            R.layout.fragment_register_2, container, false
//        )
//        val registerViewModel: RegisterViewModel by viewModels {
//            RegisterViewModelFactory((activity?.application as BaseApplication).repository)
//        }
//        binding.myViewModel = registerViewModel
//
//        binding.lifecycleOwner = this
//
//        registerViewModel.errorToast.observe(viewLifecycleOwner, Observer {
//                hasError ->  //Boolean
//            if(hasError == true) {
//                Toast.makeText(requireContext(),"Invalid inputs! Please fill all the fields with valid username/password", Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        registerViewModel.navigateto.observe(viewLifecycleOwner, Observer {
//                hasFinished ->  // if it is true
//            if(hasFinished == true) {
//                navigateToLogin()
//                registerViewModel.doneNavigating()
//            }
//        })
//
//        registerViewModel.errorToastUserName.observe(viewLifecycleOwner, Observer {
//                userNameExist ->
//            if(userNameExist == true) {
//                Toast.makeText(requireContext(),
//                    "Username already exists. Please choose another username.",
//                    Toast.LENGTH_SHORT).show()
//                registerViewModel.donetoastUserName()
//            }
//        })
//
//        return binding.root
//    }
//
//    private fun navigateToLogin() {
////        Log.i("MYTAG","Navigate to login")
////        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
////        NavHostFragment.findNavController(this).navigate(action)
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val btnSend = view.findViewById<Button>(R.id.register_btn2)
//        btnSend.setOnClickListener {
//            view.findNavController().navigate(R.id.register3Fragment)
//        }
//
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
//    }
//}
class Register2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSend = view.findViewById<Button>(R.id.register_btn2)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.register3Fragment)
        }

        val age = view.findViewById<TextView>(R.id.register_age_num)
        val minusbtn = view.findViewById<ImageButton>(R.id.register_age_minus)
        minusbtn.setOnClickListener {
            val gotage = Integer.parseInt(age.toString())
            val newage = gotage - 1
            age.text = newage.toString()
        }

        val addbtn = view.findViewById<ImageButton>(R.id.register_age_add)
        addbtn.setOnClickListener {
            val gotage = Integer.parseInt(age.toString())
            val newage = gotage + 1
            age.text = newage.toString()
        }
    }}
