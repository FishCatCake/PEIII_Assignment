package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.dao.HPVDao
import com.example.pe_assignment.database.entity.HPV
import kotlinx.coroutines.flow.Flow

class HpvRepository (private val dao: HPVDao){

    suspend fun insert(hpv: HPV) {
        dao.insert(hpv)
    }

    // Get  list
    var hpvList: Flow<List<HPV>> = dao.getRecord()
    fun getRecord(): Flow<List<HPV>> {
        return hpvList
    }
}