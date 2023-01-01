package com.example.pe_assignment.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.database.repository.RegisterRepository
import java.lang.IllegalArgumentException

class LoginViewModelFactory(
    private  val repository: RegisterRepository/*,
    private val application: Application*/
): ViewModelProvider.Factory{
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository/*, application*/) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}