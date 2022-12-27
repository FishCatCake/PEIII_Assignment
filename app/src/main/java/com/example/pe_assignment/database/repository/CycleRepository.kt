package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.dao.CycleDao
import com.example.pe_assignment.database.entity.Cycle
import kotlinx.coroutines.flow.Flow

class CycleRepository (private val dao:CycleDao){
    // Register / Sign Up
    suspend fun insert(cycle: Cycle) {
        dao.insert(cycle)
    }

    // Get cycle list
    var cycleList: Flow<List<Cycle>> = dao.getCycles()
    fun getCycles(): Flow<List<Cycle>> {
        return cycleList
    }
}