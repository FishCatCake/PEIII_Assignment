package com.example.pe_assignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.database.repository.RegisterRepository
import java.lang.IllegalArgumentException

class UserInfoFactory (
    private  val repository: RegisterRepository/*,
    private val application: Application*/
): ViewModelProvider.Factory{
    @Suppress("Unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(UserInfoViewModel::class.java)) {
            return UserInfoViewModel(repository/*, application*/) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}