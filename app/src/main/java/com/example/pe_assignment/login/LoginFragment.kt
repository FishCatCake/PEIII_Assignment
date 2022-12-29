package com.example.pe_assignment.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login, container, false
        )
        val loginViewModel: LoginViewModel by viewModels {
            LoginViewModelFactory((activity?.application as BaseApplication).repository)
        }

        binding.myLoginViewModel = loginViewModel

        binding.lifecycleOwner = this

        loginViewModel.navigatetoRegister.observe(viewLifecycleOwner, Observer {
                hasFinished ->
            if (hasFinished == true){
                // navigate to the register fragment
                navigateToRegister()
                loginViewModel.doneNavigatingRegister()  // reset navigatetoRegister to false
            }
        })

        loginViewModel.errorToast.observe(viewLifecycleOwner, Observer {
                hasError ->
            if(hasError == true){
                Toast.makeText(requireContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show()
                loginViewModel.donetoast()
            }
        })

        loginViewModel.errorToastUsername.observe(viewLifecycleOwner, Observer {
                hasError ->
            if(hasError == true){
                Toast.makeText(requireContext(), "User does not exist, please register!", Toast.LENGTH_SHORT).show()
                loginViewModel.donetoastErrorUsername()
            }
        })

        loginViewModel.errorToastInvalidPassword.observe(viewLifecycleOwner, Observer {
                hasError->
            if(hasError == true){
                Toast.makeText(requireContext(), "Invalid password. Please check your Password.", Toast.LENGTH_SHORT).show()
                loginViewModel.donetoastInvalidPassword()
            }
        })

        loginViewModel.navigatetoUserDetails.observe(viewLifecycleOwner, Observer {
                hasFinished ->
            if (hasFinished == true){
                Log.i("MYTAG","insidi observe")
                navigateUserDetails()
                loginViewModel.doneNavigatingUserDetails()
            }
        })
        return binding.root
//            // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register_1, container, false)
    }

    private fun navigateToRegister() {
        findNavController().navigate(R.id.action_loginFragment_to_register1Fragment)
    }

    private fun navigateUserDetails() {
        var name = logincontainer.name.text.toString()
        val action = LoginFragmentDirections.actionLoginFragmentToHomeActivity(name)
        logincontainer.findNavController().navigate(action)
        Log.i("before",name)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val registertextview = view.findViewById<TextView>(R.id.register_textview)
//        val btnSignIn =  view.findViewById<Button>(R.id.btn_sign_in)
//
//        registertextview.setOnClickListener {
//            view.findNavController().navigate(R.id.register1Fragment)
//        }
//        btnSignIn.setOnClickListener {
//            view.findNavController().navigate(R.id.homeActivity)
//        }
    }




}