package com.example.pe_assignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    // register new user
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user_table ORDER BY id")
    fun getUsers(): Flow<List<User>>


    @Query("DELETE FROM user_table")
    fun deleteAll()

    // Login
    @Query("SELECT * FROM user_table WHERE account = :userName")
    fun getUserCredential(userName: String): User
}