package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.entity.CancerRecord
import com.example.pe_assignment.database.dao.CancerRecordDao
import kotlinx.coroutines.flow.Flow

class CancerRecordRepository (private val dao: CancerRecordDao){
    suspend fun insert(record: CancerRecord) {
        dao.insert(record)
    }

    // Get  list
    var recordList: Flow<List<CancerRecord>> = dao.getRecord()
    fun getRecord(): Flow<List<CancerRecord>> {
        return recordList
    }
}