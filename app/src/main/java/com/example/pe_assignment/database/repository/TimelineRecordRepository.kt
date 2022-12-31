package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.entity.TimelineRecord
import com.example.pe_assignment.database.dao.TimelineRecordDao
import kotlinx.coroutines.flow.Flow

class TimelineRecordRepository (private val dao: TimelineRecordDao){
    suspend fun insert(Timeline: TimelineRecord) {
        dao.insert(Timeline)
    }

    // Get  list
    var recordList: Flow<List<TimelineRecord>> = dao.getTimeline()
    fun getTimeline(): Flow<List<TimelineRecord>> {
        return recordList
    }
}