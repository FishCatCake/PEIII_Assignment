package com.example.pe_assignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TimelineRecordDAO {

    @Insert
    suspend fun insert(timeline: TimelineRecord)

    @Query("SELECT * FROM cancer_timeline ORDER BY id")
    fun getTimeline(): Flow<List<TimelineRecord>>

    @Query("DELETE FROM cancer_timeline")
    fun deleteAll()

}