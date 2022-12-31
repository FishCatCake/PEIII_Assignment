package com.example.pe_assignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserCancerPhraseDAO {
    // register new cancer user
    @Insert
    suspend fun insert(cuser: UserCancerPhrase)

//    @Query("SELECT * FROM user_table ORDER BY id")
//    fun getUsers(): Flow<List<User>>

    @Query("DELETE FROM user_cancer_phrase_table")
    fun deleteAll()

}