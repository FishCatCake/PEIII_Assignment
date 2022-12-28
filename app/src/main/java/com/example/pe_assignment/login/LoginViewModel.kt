package com.example.pe_assignment.login

import android.app.Application
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.pe_assignment.RegisterRepository
import com.example.pe_assignment.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.math.BigInteger
import java.security.MessageDigest

class LoginViewModel(private val repository: RegisterRepository) :
    ViewModel(), Observable {

//    var id: Int = 0

    @Bindable
    val inputUsername = MutableLiveData<String?>()

    @Bindable
    val inputPassword = MutableLiveData<String?>()

    fun setName(name: String) {
        inputUsername.value = name
    }
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
//                        id = user.id
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

//    suspend fun getID(){
//        var id: User = repository.getID(inputUsername.value.toString())
//    }

    suspend fun getUserCredential(){
        var name: User = repository.getUserCredential(inputUsername.value.toString())
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