package com.example.pe_assignment.cancer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pe_assignment.CancerNewRepository
import com.example.pe_assignment.RegisterRepository
import com.example.pe_assignment.User
import com.example.pe_assignment.UserCancerPhrase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CancerUserViewModel (private val repository: CancerNewRepository) : ViewModel(){
    private val _phrase = MutableLiveData<String?>("")
    val phrase: MutableLiveData<String?> = _phrase
    private val _userid = MutableLiveData<Long?>()
    val userid: MutableLiveData<Long?> = _userid

    fun setPhrase(phrase: String) {
        _phrase.value = phrase
    }

    fun setUserId(uid: Long) {
        _userid.value = uid
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
    fun addNew() {  // Empty field and validate username and password
        Log.i("MYTAG", "reg func")
        if(
            (_phrase.value == null)
//            ||
//            (_userid.value == null)
        ) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
//                val userInfo = repository.getUserCredential(_account.value.toString())
//                if(userInfo == null) {  // No existing record with the same username
                    val phrase: String = _phrase.value!!
//                    val uid: Long = _userid.value!!
                    val cuser = UserCancerPhrase(0,phrase,1)
                    insert(cuser)
                    _errorToastUserName.value = false
                    _navigateto.value = true  // already inserted
                    _phrase.value = null
                    _userid.value = null
//                }
//                else {
//                    _errorToastUserName.value = true
//                }
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

//    fun donetoast() {
//        _errorToast.value = false
//        Log.i("MYTAG", "Done taoasting ")
//    }
//
//    fun donetoastUserName() {
//        _errorToastUserName.value = false
//        Log.i("MYTAG", "Done taoasting username")
//    }

    private fun insert(cuser: UserCancerPhrase) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(cuser)
        }
}