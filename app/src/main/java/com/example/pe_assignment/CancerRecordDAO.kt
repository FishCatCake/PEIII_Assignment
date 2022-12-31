package com.example.pe_assignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CancerRecordDAO {

    @Insert
    suspend fun insert(record: CancerRecord)

    @Query("SELECT * FROM cancer_record ORDER BY id")
    fun getRecord(): Flow<List<CancerRecord>>

    @Query("DELETE FROM cancer_record")
    fun deleteAll()

}