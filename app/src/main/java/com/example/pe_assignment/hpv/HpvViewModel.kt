package com.example.pe_assignment.hpv


import android.provider.SyncStateContract.Helpers.insert
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.pe_assignment.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.Date

class HpvViewModel(private val repository: HpvRepository) :
    ViewModel(), Observable {

    private val _reviewTime = MutableLiveData<Int?>(0)
    fun setDate(reviewTime: String) {
        _reviewTime.value = reviewTime.toInt()
    }

//    @Bindable
//    val firstDose = MutableLiveData<Date?>()
//
//    @Bindable
//    val secondDose = MutableLiveData<Date?>()
//
//    @Bindable
//    val thirdDose = MutableLiveData<Date?>()


    private val _navigateto = MutableLiveData<Boolean>()
    val navigateto: LiveData<Boolean>
        get() = _navigateto

    private val _errorToast = MutableLiveData<Boolean>()
    val errorToast: LiveData<Boolean>
        get() = _errorToast

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun Date() {
        Log.i("Date", "Enter")
        if(_reviewTime.value == null) {
            _errorToast.value = true
        } else {
            uiScope.launch {
                val reviewTime: Int = _reviewTime.value!!
                val hpv = HPV(0,reviewTime)
                insert(hpv)
                _navigateto.value = true
            }

    }

}

    private fun insert(hpv: HPV) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(hpv)
        }

    fun doneNavigating() {
        _navigateto.value = false
        Log.i("MYTAG", "Done navigating ")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }


}