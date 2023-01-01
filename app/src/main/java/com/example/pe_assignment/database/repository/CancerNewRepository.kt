package com.example.pe_assignment.database.repository

import com.example.pe_assignment.database.entity.UserCancerPhrase
import com.example.pe_assignment.database.dao.UserCancerPhraseDao

class CancerNewRepository (private val dao: UserCancerPhraseDao){
    suspend fun insert(cuser: UserCancerPhrase) {
        dao.insert(cuser)
    }
}