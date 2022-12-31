package com.example.pe_assignment

import kotlinx.coroutines.flow.Flow

class TimelineRecordRepository (private val dao: TimelineRecordDAO){
    suspend fun insert(Timeline: TimelineRecord) {
        dao.insert(Timeline)
    }

    // Get  list
    var recordList: Flow<List<TimelineRecord>> = dao.getTimeline()
    fun getTimeline(): Flow<List<TimelineRecord>> {
        return recordList
    }
}