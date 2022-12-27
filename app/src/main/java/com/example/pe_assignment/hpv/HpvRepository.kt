package com.example.pe_assignment.hpv

import kotlinx.coroutines.flow.Flow

class HpvRepository (private val dao: HPVDao){

    suspend fun insert(hpv: HPV) {
        dao.insert(hpv)
    }


    var hpvList: Flow<List<HPV>> = dao.getAll()
    fun getAll(): Flow<List<HPV>> {
        return hpvList
    }


    suspend fun getTime(id:Int): HPV {
        return dao.getTime(id)
    }

}