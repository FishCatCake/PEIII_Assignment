package com.example.pe_assignment.login

//import android.os.Build.VERSION_CODES.R

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentRegister1Binding


class Register1Fragment : Fragment() {
    private var binding: FragmentRegister1Binding? = null
    private val sharedViewModel: RegisterViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentRegister1Binding.inflate(
            inflater, container, false
        )
        val sharedViewModel: RegisterViewModel by activityViewModels() {
            RegisterViewModelFactory((activity?.application as BaseApplication).repository)
        }


        sharedViewModel.errorToast.observe(viewLifecycleOwner, Observer {
                hasError ->  //Boolean
            if(hasError == true) {
                Toast.makeText(requireContext(),"Invalid inputs! Please fill all the fields with valid username/password", Toast.LENGTH_SHORT).show()
            }
        })

        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
                goToNextScreen()
                sharedViewModel.doneNavigating()
            }
        })

        sharedViewModel.errorToastUserName.observe(viewLifecycleOwner, Observer {
                userNameExist ->
            if(userNameExist == true) {
                Toast.makeText(requireContext(),
                    "Username already exists. Please choose another username.",
                    Toast.LENGTH_SHORT).show()
                sharedViewModel.donetoastUserName()
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
            register1Fragment = this@Register1Fragment
        }

    }

    fun goToNextScreen() {
        val account: String = binding?.userAccount?.text.toString()
        val password: String = binding?.userPassword?.text.toString()
        val passwordre: String = binding?.userPasswordre?.text.toString()
        sharedViewModel.setAccount(account)
        sharedViewModel.setPassword(password)
        sharedViewModel.setPasswordRe(passwordre)
        findNavController().navigate(R.id.action_register1Fragment_to_register2Fragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}