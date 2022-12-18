package com.example.pe_assignment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class UserInfoViewModel (private val repository: RegisterRepository):
    ViewModel() {

    val users: LiveData<List<User>> = repository.getUsers().asLiveData()
    init {
        Log.i("MYTAG","inside_users_Lisrt_init")
    }


    private val _navigateto = MutableLiveData<Boolean>()

    val navigateto: LiveData<Boolean>
        get() = _navigateto

    fun doneNavigating(){
        _navigateto.value=false
    }

    fun backButtonclicked(){
        _navigateto.value = true
    }

}