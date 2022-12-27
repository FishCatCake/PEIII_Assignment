package com.example.pe_assignment.database

import androidx.room.Insert
import androidx.room.Query
import com.example.pe_assignment.User
import kotlinx.coroutines.flow.Flow

interface HPVDao {
    @Insert
    suspend fun insert(hpv: HPV)

    @Query("SELECT * FROM hpv_table")
    fun getAll(): Flow<List<HPV>>

    @Query("DELETE FROM user_table")
    fun deleteAll()

    @Query("SELECT Review_time_day FROM hpv_table")
    fun getReviewDay(): List<HPV>

//    @Query("SELECT First_vaccine_time FROM hpv_table")
//    fun getFirstVaccineTime(): List<HPV>
//
//    @Query("SELECT Second_vaccine_time FROM hpv_table")
//    fun getSecondVaccineTime(): List<HPV>
//
//    @Query("SELECT Third_vaccine_time FROM hpv_table")
//    fun getThirdVaccineTime(): List<HPV>
}