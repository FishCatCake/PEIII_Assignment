package com.example.pe_assignment.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pe_assignment.database.entity.UserCancerPhrase

@Dao
interface UserCancerPhraseDao {
    // register new cancer user
    @Insert
    suspend fun insert(cuser: UserCancerPhrase)

//    @Query("SELECT * FROM user_table ORDER BY id")
//    fun getUsers(): Flow<List<User>>

    @Query("DELETE FROM user_cancer_phrase_table")
    fun deleteAll()

}