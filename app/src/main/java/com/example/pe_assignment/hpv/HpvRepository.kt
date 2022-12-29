package com.example.pe_assignment.hpv

import kotlinx.coroutines.flow.Flow

class HpvRepository (private val dao: HPVDao){

    suspend fun insert(hpv: HPV) {
        dao.insert(hpv)
    }

    // Get  list
    var hpvList: Flow<List<HPV>> = dao.getRecord()
    fun getRecord(): Flow<List<HPV>> {
        return hpvList
    }
}