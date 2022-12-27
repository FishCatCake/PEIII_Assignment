package com.example.pe_assignment.login

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.pe_assignment.database.repository.RegisterRepository
import com.example.pe_assignment.database.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest

class LoginViewModel(private val repository: RegisterRepository) :
    ViewModel(), Observable {

    @Bindable
    val inputUsername = MutableLiveData<String?>()

    @Bindable
    val inputPassword = MutableLiveData<String?>()

    private val _navigatetoRegister = MutableLiveData<Boolean>()
    val navigatetoRegister: LiveData<Boolean>
        get() = _navigatetoRegister  // if it is true, then we navigate to the Signup/Register screen

    private val _navigatetoUserDetails = MutableLiveData<Boolean>()
    val navigatetoUserDetails: LiveData<Boolean>
        get() = _navigatetoUserDetails

    private val _errorToast = MutableLiveData<Boolean>()
    val errorToast: LiveData<Boolean>
        get() = _errorToast

    private val _errorToastInvalidPassword = MutableLiveData<Boolean>()
    val errorToastInvalidPassword: LiveData<Boolean>
        get() = _errorToastInvalidPassword

    private val _errorToastUsername = MutableLiveData<Boolean>()
    val errorToastUsername: LiveData<Boolean>
        get() = _errorToastUsername


    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun md5Hash(input: String): String {
        val passwordToHash: String = input
        var hashedPassword: String? = null

        val md = MessageDigest.getInstance("MD5")
        hashedPassword = BigInteger(1, md.digest(passwordToHash.toByteArray())).toString(16).padStart(32, '0')

        return hashedPassword
    }

    // Login function
    fun login() {
        if(inputUsername.value == null ||
            inputPassword.value == null) {
            _errorToast.value = true
        } else {
            uiScope.launch {
                val user: User = repository.getUserCredential(inputUsername.value.toString())
                if(user != null) {
                    if(user.password == md5Hash(inputPassword.value.toString())) {  // valid user with correct password
                        _navigatetoUserDetails.value = true
                        inputUsername.value = null
                        inputPassword.value = null
                    } else {   // invalid password
                        _errorToastInvalidPassword.value = true
                    }
                } else {  // username does not exist (invalid username)
                    _errorToastUsername.value = true
                }
            }
        }
    }

    fun signUp() {
        _navigatetoRegister.value = true
    }

    fun doneNavigatingRegister() {
        _navigatetoRegister.value = false
    }

    fun doneNavigatingUserDetails() {
        _navigatetoUserDetails.value = false
    }

    fun donetoast() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    fun donetoastErrorUsername() {
        _errorToastUsername.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    fun donetoastInvalidPassword() {
        _errorToastInvalidPassword.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}