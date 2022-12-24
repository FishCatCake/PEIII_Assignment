package com.example.pe_assignment.cycle

import androidx.lifecycle.ViewModel
import androidx.room.TypeConverters
import com.example.pe_assignment.database.Converters
import com.example.pe_assignment.database.Cycle
import com.example.pe_assignment.database.CycleDAO
import kotlinx.coroutines.flow.Flow
import java.util.*

//@TypeConverters(Converters::class)
class CycleViewModel(private val cycleDAO: CycleDAO): ViewModel(){
    fun insertTemp(temperature: Float, startTime: Date) = CycleDAO.addDataTemp(Cycle(0, startTime, temperature))
    fun getTemp(): Flow<kotlin.collections.List<Cycle>> = CycleDAO.getDataTemp()
}