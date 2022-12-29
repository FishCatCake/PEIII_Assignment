package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.dao.CycleDao
import com.example.pe_assignment.database.entity.Cycle
import kotlinx.coroutines.flow.Flow

class PeriodRepository (private val dao:CycleDao) {
    suspend fun insert(cycle: Cycle) {
        dao.insert(cycle)
    }

    // get all
    var cycleList:Flow<List<Cycle>> = dao.getAll()
    fun getAll(): Flow<List<Cycle>>{
        return cycleList
    }

    // Get temp list
    var tempList: Flow<List<Float>> = dao.getTemp()
    fun getTemp(): Flow<List<Float>>{
        return tempList
    }
    // get date list
    var dateList:Flow<List<Float>> = dao.getDates()
    fun getDates(): Flow<List<Float>> {
        return dateList
    }
}