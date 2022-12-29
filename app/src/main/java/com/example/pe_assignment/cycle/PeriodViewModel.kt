package com.example.pe_assignment.cycle

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pe_assignment.database.entity.Cycle
import com.example.pe_assignment.database.repository.PeriodRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PeriodViewModel(private val repository:PeriodRepository)
    : ViewModel(){

    private val _inputTemp = MutableLiveData<String>("")
    fun setTemp(inputTemp: String){
        _inputTemp.value = inputTemp
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

   fun insertTemp(){
       uiScope.launch {
           val inputTemp: String = _inputTemp.value!!
           val cycle = Cycle(0, inputTemp)
           insert(cycle)
       }
   }

    override fun onCleared() {
        super.onCleared()
    }

    fun doneNavigating() {
        _navigateto.value = false
        Log.i("Temp", "Done navigating ")
    }


    // insert temp
    private fun insert(cycle: Cycle) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(cycle)
        }
}