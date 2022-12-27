package com.example.pe_assignment.cycle

import androidx.lifecycle.ViewModel
import com.example.pe_assignment.database.Cycle
import com.example.pe_assignment.database.CycleDAO
import kotlinx.coroutines.flow.Flow
import java.util.*

//@TypeConverters(Converters::class)
class CycleViewModel(private val cycleDAO: CycleDAO): ViewModel(){
    fun insertTemp(year: Int, month: Int, date: Int, temperature: Double) = CycleDAO.addDataTemp(Cycle(0, year,month,date, temperature))
    fun getTemp(): Flow<kotlin.collections.List<Cycle>> = CycleDAO.getDataTemp()
}