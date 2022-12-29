package com.example.pe_assignment.cancer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.CancerNewRepository
import com.example.pe_assignment.CancerRecordRepository
import com.example.pe_assignment.TimelineRecord
import com.example.pe_assignment.TimelineRecordRepository
import java.lang.IllegalArgumentException

class CancerTimelineViewModelFactory(private val repository: TimelineRecordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CancerTimelineViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CancerTimelineViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}