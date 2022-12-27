package com.example.pe_assignment.database

import kotlinx.coroutines.flow.Flow

class HpvRepository (private val dao: HPVDao){
    // Register / Sign Up
    suspend fun insert(hpv: HPV) {
        dao.insert(hpv)
    }

    var HPVList: Flow<List<HPV>> = dao.getAll()
    fun getAll(): Flow<List<HPV>> {
        return HPVList
    }

//    var firstVaccineList: List<HPV> = dao.getFirstVaccineTime()
//    fun getFirstVaccineTime(): List<HPV> {
//        return firstVaccineList
//    }
//
//    var secondVaccineList: List<HPV> = dao.getSecondVaccineTime()
//    fun getSecondVaccineTime(): List<HPV> {
//        return secondVaccineList
//    }
//
//    var thirdVaccineList: List<HPV> = dao.getThirdVaccineTime()
//    fun getThirdVaccineTime(): List<HPV> {
//        return thirdVaccineList
//    }

}