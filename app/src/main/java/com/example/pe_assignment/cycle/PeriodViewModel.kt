package com.example.pe_assignment.cycle

import android.util.Log
import androidx.lifecycle.*
import com.example.pe_assignment.database.entity.Cycle
import com.example.pe_assignment.database.repository.PeriodRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class PeriodViewModel(private val repository:PeriodRepository)
    : ViewModel(){

    private val _inputTemp = MutableLiveData<Float>()
    fun setTemp(inputTemp: String){
        _inputTemp.value = inputTemp.toFloat()
    }

    // calendar data
    private val _inputDate = MutableLiveData<Float>()
    private val _inputMonth = MutableLiveData<Float>()
    private val _inputYear = MutableLiveData<Float>()
    // date
    fun setDate(inputDate: String){
        _inputDate.value = inputDate.toFloat()
    }
    // month
    fun setMonth(inputMonth: String){
        _inputMonth.value = inputMonth.toFloat()
    }
    // year
    fun setYear(inputYear: String){
        _inputYear.value = inputYear.toFloat()
    }

    //get all
    fun getAll(): Flow<List<Cycle>> = repository.getAll()
    // get temp list
    val tempList: Flow<List<Float>> = repository.getTemp()
    // get date list
    val dateList: Flow<List<Float>> = repository.getDates()


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

    // insert all
   fun insertAll(){
       uiScope.launch {
           val inputTemp: Float = _inputTemp.value!!
           val inputDate: Float = _inputDate.value!!
           val inputMonth: Float = _inputMonth.value!!
           val inputYear: Float = _inputYear.value!!

           val cycle = Cycle(0, inputYear, inputMonth, inputDate, inputTemp)
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