package com.example.pe_assignment.cancer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.database.repository.CancerNewRepository
import java.lang.IllegalArgumentException

class CancerUserViewModelFactory(private val repository: CancerNewRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CancerUserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CancerUserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}