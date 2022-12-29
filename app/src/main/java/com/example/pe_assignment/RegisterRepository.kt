package com.example.pe_assignment

import kotlinx.coroutines.flow.Flow

class RegisterRepository (private val dao: UserDao){
    // Register / Sign Up
    suspend fun insert(user: User) {
        dao.insert(user)
    }


    // Get user list
    var userList: Flow<List<User>> = dao.getUsers()
    fun getUsers(): Flow<List<User>> {
        return userList
    }

    // Login
    suspend fun getUserCredential(userName: String): User {
        return dao.getUserCredential(userName)
    }

}