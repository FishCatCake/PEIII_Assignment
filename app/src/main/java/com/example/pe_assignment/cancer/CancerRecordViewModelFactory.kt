package com.example.pe_assignment.cancer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.database.repository.CancerRecordRepository
import java.lang.IllegalArgumentException

class CancerRecordViewModelFactory(private val repository: CancerRecordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CancerRecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CancerRecordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}