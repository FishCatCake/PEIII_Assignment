package com.example.pe_assignment.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pe_assignment.database.entity.CancerRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface CancerRecordDao {

    @Insert
    suspend fun insert(record: CancerRecord)

    @Query("SELECT * FROM cancer_record ORDER BY id")
    fun getRecord(): Flow<List<CancerRecord>>

    @Query("DELETE FROM cancer_record")
    fun deleteAll()

}