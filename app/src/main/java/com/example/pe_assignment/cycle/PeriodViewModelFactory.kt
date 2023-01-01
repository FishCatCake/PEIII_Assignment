package com.example.pe_assignment.cycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.database.repository.PeriodRepository
import java.lang.IllegalArgumentException

class PeriodViewModelFactory (
    private val repository: PeriodRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(PeriodViewModel::class.java)) {
            return PeriodViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}