package com.example.pe_assignment

class CancerNewRepository (private val dao: UserCancerPhraseDAO){
    suspend fun insert(cuser: UserCancerPhrase) {
        dao.insert(cuser)
    }
}