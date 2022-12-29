package com.example.pe_assignment

import kotlinx.coroutines.flow.Flow

class CancerRecordRepository (private val dao: CancerRecordDAO){
    suspend fun insert(record: CancerRecord) {
        dao.insert(record)
    }

    // Get  list
    var recordList: Flow<List<CancerRecord>> = dao.getRecord()
    fun getRecord(): Flow<List<CancerRecord>> {
        return recordList
    }
}