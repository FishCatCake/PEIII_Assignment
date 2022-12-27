package com.example.pe_assignment.hpv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class HpvViewModelFactory(private val repository: HpvRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HpvViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HpvViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}