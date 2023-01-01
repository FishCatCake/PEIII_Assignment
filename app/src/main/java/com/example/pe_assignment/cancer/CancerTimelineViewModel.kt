package com.example.pe_assignment.cancer

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pe_assignment.database.entity.TimelineRecord
import com.example.pe_assignment.database.repository.TimelineRecordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CancerTimelineViewModel (private val repository: TimelineRecordRepository) : ViewModel(){
    private val _year = MutableLiveData<String?>("")
    val year: MutableLiveData<String?> = _year
    private val _month = MutableLiveData<String?>("")
    val month: MutableLiveData<String?> = _month
    private val _date = MutableLiveData<String?>("")
    val date: MutableLiveData<String?> = _date
    private val _title = MutableLiveData<String?>("")
    val title: MutableLiveData<String?> = _title
    private val _description = MutableLiveData<String?>("")
    val description: MutableLiveData<String?> = _description
    private val _file = MutableLiveData<String?>("")
    val file: MutableLiveData<String?> = _file


    fun setYear(year: String) {
        _year.value = year
    }

    fun setMonth(month: String) {
        _month.value = month
    }
    fun setDate(date: String) {
        _date.value = date
    }

    fun setTitle(title: String) {
        _title.value = title
    }
    fun setDescription(description: String) {
        _description.value = description
    }

    fun setFile(file: String) {
        _file.value = file
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
    fun addTimeline() {  // Empty field and validate username and password
        Log.i("MYTAG", "reg func")
        if(
            (_year.value == null)||
            (_month.value == null)||
            (_date.value == null)||
            (_title.value == null)
        ) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
//                val userInfo = repository.getUserCredential(_account.value.toString())
//                if(userInfo == null) {  // No existing record with the same username
                    val year: String = _year.value.toString()
                    val month: String = _month.value.toString()
                    val date: String = _date.value.toString()
                    val title: String = _title.value.toString()
                    val description: String = _description.value.toString()
                    val file: String = _file.value.toString()

                    val ctimeline = TimelineRecord(0,year,month,date,title,description,file,"1")
                    insert(ctimeline)
                    _errorToastUserName.value = false
                    _navigateto.value = true  // already inserted
                    _year.value = null
                    _month.value = null
//                    _date.value = null
                    _title.value = null
                    _description.value = null
                    _file.value = null
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


    private fun insert(timeline: TimelineRecord) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(timeline)
        }

}