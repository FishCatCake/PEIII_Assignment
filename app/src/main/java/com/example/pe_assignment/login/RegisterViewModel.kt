package com.example.pe_assignment.login


import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.pe_assignment.RegisterRepository
import com.example.pe_assignment.User
import kotlinx.coroutines.*
import java.lang.IllegalArgumentException
import java.math.BigInteger
import java.security.MessageDigest

import java.util.regex.Pattern

class RegisterViewModel (private val repository: RegisterRepository) :
    ViewModel(), Observable {

    var userDetailsLiveData = MutableLiveData<List<User>>()

    @Bindable
    val inputAccount = MutableLiveData<String?>()

    @Bindable
    val inputPassword = MutableLiveData<String?>()

    @Bindable
    val inputPasswordRe = MutableLiveData<String?>()

    @Bindable
    val inputName = MutableLiveData<String?>()

    @Bindable
    val inputAge = MutableLiveData<Int?>()


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
        Log.i("eee", "reg func")
        if((inputAccount.value == null) ||
            (inputPassword.value == null) ||
            (inputPasswordRe.value == null) ||
            (!validate(inputPassword.value.toString()))) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
                val userInfo = repository.getUserCredential(inputAccount.value.toString())
                if(userInfo == null) {  // No existing record with the same username
                    val account: String = inputAccount.value!!
                    val password: String = md5Hash(inputPassword.value!!)
                    val name: String = inputName.value!!
                    val age: Int = inputAge.value!!
                    val user = User(0,account,password,name,age)
                    insert(user)
                    _errorToastUserName.value = false
                    _navigateto.value = true  // already inserted
                    inputName.value = null
                    inputAge.value = null
                    inputAccount.value = null
                    inputPassword.value = null
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

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}

class RegisterViewModelFactory(private val repository: RegisterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}