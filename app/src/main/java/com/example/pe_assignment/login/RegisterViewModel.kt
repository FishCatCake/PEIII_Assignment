package com.example.pe_assignment.login


import android.util.Log
import androidx.lifecycle.*
import com.example.pe_assignment.database.repository.RegisterRepository
import com.example.pe_assignment.database.entity.User
import kotlinx.coroutines.*
import java.math.BigInteger
import java.security.MessageDigest

import java.util.regex.Pattern


class RegisterViewModel(private val repository: RegisterRepository)
    : ViewModel(){
//    var userDetailsLiveData = MutableLiveData<List<User>>()

    private val _account = MutableLiveData<String?>("")
    private val _name = MutableLiveData<String?>("")


    fun setAccount(useraccount: String) {
        _account.value = useraccount
    }

    fun setName(username: String) {
        _name.value = username
    }
    private val _password = MutableLiveData<String?>("")
    private val _passwordRe = MutableLiveData<String?>("")

    fun setPassword(password: String) {
        _password.value = password
    }
    fun setPasswordRe(passwordre: String) {
        _passwordRe.value = passwordre
    }

    private val _age = MutableLiveData<String?>("")
    fun setAge(age: String) {
        _age.value = age
    }

    private val _navigateto = MutableLiveData<Boolean>()
    val navigateto: LiveData<Boolean>
        get() = _navigateto

    private val _errorToast = MutableLiveData<Boolean>()
    val errorToast: LiveData<Boolean>
        get() = _errorToast

    private val _errorToastUserName = MutableLiveData<Boolean>()
    val errorToastUserName: LiveData<Boolean>
        get() = _errorToastUserName

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun validate(input: String): Boolean {
        val PATTERN: Pattern =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,}" +                // at least 6 characters
                    "$")

        return PATTERN.matcher(input).matches()
    }

    fun md5Hash(input: String): String {
        val passwordToHash: String = input
        var hashedPassword: String? = null

        val md = MessageDigest.getInstance("MD5")
        hashedPassword = BigInteger(1, md.digest(passwordToHash.toByteArray())).toString(16).padStart(32, '0')

        return hashedPassword
    }


//TODO: need to validate the password TWICE consistent
    fun register() {  // Empty field and validate username and password
        Log.i("MYTAG", "reg func")
        if(
            (_account.value == null) ||
            (_password.value == null) ||
            (_passwordRe.value == null) ||
            (!validate(_password.value.toString()))
        ) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
                val userInfo = repository.getUserCredential(_account.value.toString())
                if(userInfo == null) {  // No existing record with the same username
                    val account: String = _account.value!!
                    val password: String = md5Hash(_password.value!!)
                    val name: String = _name.value!!
                    val age: String = _age.value!!
                    val user = User(0,account,password,name,age)
                    insert(user)
                    _errorToastUserName.value = false
                    _navigateto.value = true  // already inserted
                    _account.value = null
                    _age.value = null
                    _name.value = null
                    _password.value = null
                }
                else {
                    _errorToastUserName.value = true
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

    fun doneNavigating() {
        _navigateto.value = false
        Log.i("MYTAG", "Done navigating ")
    }

    fun donetoast() {
        _errorToast.value = false
        Log.i("MYTAG", "Done taoasting ")
    }

    fun donetoastUserName() {
        _errorToastUserName.value = false
        Log.i("MYTAG", "Done taoasting username")
    }

    private fun insert(user: User) : Job =
        viewModelScope.launch(Dispatchers.IO) {
        repository.insert(user)
    }
}


