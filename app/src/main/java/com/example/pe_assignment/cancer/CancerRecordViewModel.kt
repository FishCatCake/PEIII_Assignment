package com.example.pe_assignment.cancer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pe_assignment.database.entity.CancerRecord
import com.example.pe_assignment.database.repository.CancerRecordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CancerRecordViewModel (private val repository: CancerRecordRepository) : ViewModel(){
    private val _year = MutableLiveData<String?>("")
    val year: MutableLiveData<String?> = _year
    private val _month = MutableLiveData<String?>("")
    val month: MutableLiveData<String?> = _month
    private val _date = MutableLiveData<String?>("")
    val date: MutableLiveData<String?> = _date
    private val _time = MutableLiveData<String?>("")
    val time: MutableLiveData<String?> = _time
    private val _sym = MutableLiveData<String?>("")
    val sym: MutableLiveData<String?> = _sym
    private val _syma = MutableLiveData<String?>("")
    val syma: MutableLiveData<String?> = _syma


    fun setYear(year: String) {
        _year.value = year
    }

    fun setMonth(month: String) {
        _month.value = month
    }
    fun setDate(date: String) {
        _date.value = date
    }
    fun setTime(time: String) {
        _time.value = time
    }
    fun setSym(sym: String) {
        _sym.value = sym
    }

    fun setSyma(syma: String) {
        _syma.value = syma
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
    fun addRecord() {  // Empty field and validate username and password
        Log.i("MYTAG", "reg func")
        if(
            (_year.value == null)||
            (_month.value == null)||
            (_date.value == null)||
            (_time.value == null)
        ) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
//                val userInfo = repository.getUserCredential(_account.value.toString())
//                if(userInfo == null) {  // No existing record with the same username
                    val year: String = _year.value.toString()
                    val month: String = _month.value.toString()
                    val date: String = _date.value.toString()
                    val time: String = _time.value.toString()
                    val sym: String = _sym.value.toString()
                    val syma: String = _syma.value.toString()

                    val crecord = CancerRecord(0,year,month,date,time,sym,syma,"1")
                    insert(crecord)
                    _errorToastUserName.value = false
                    _navigateto.value = true  // already inserted
                    _year.value = null
                    _month.value = null
                    _date.value = null
                    _time.value = null
                    _sym.value = null
                    _syma.value = null
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


    private fun insert(record: CancerRecord) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(record)
        }

}