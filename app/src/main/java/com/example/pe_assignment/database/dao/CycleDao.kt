package com.example.pe_assignment.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pe_assignment.database.entity.Cycle
import com.example.pe_assignment.database.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface CycleDao {
    // register new user
    @Insert
    suspend fun insert(cycle: Cycle)

    @Query("SELECT cycle_date FROM cycle_table ORDER BY id")
    fun getDates(): Flow<List<Int>>

    @Query("SELECT temperature FROM cycle_table ORDER BY cycle_date")
    fun getTemp(): Flow<List<String>>

//    @Query("SELECT temperature FROM cycle_table ORDER BY id")
//    fun getTemp(): Flow<List<>>

//    // Login
//    @Query("SELECT * FROM cycle_table WHERE id = :userName")
//    suspend fun getUserCredential(userName: String): User
}