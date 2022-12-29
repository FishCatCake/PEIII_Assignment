package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.dao.CycleDao
import com.example.pe_assignment.database.entity.Cycle
import kotlinx.coroutines.flow.Flow

class PeriodRepository (private val dao:CycleDao) {
    suspend fun insert(cycle: Cycle) {
        dao.insert(cycle)
    }

    // Get temp list
    var tempList: Flow<List<String>> = dao.getTemp()
    fun getTemp(): Flow<List<String>> {
        return tempList
    }
    // get date list
    var dateList:Flow<List<Int>> = dao.getDates()
    fun getDates(): Flow<List<Int>> {
        return dateList
    }
}