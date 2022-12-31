package com.example.pe_assignment.hpv

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pe_assignment.User
import kotlinx.coroutines.flow.Flow

@Dao
interface HPVDao {

    @Insert
    suspend fun insert(hpv: HPV)

    @Query("SELECT * FROM hpv_table ORDER BY id")
    fun getRecord(): Flow<List<HPV>>

    @Query("DELETE FROM hpv_table")
    fun deleteAll()

}