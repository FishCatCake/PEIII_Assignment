package com.example.pe_assignment.cycle

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.pe_assignment.database.CycleDAO
//import java.lang.IllegalArgumentException

//class CycleViewModelFactory(private val cycleDAO: CycleDAO): ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//
//        if(modelClass.isAssignableFrom(CycleViewModel::class.java)){
//            @Suppress("CAST ...")
//            return CycleViewModel(cycleDAO) as T
//        }
//        throw IllegalArgumentException("Unknown model")
//    }
//
//}