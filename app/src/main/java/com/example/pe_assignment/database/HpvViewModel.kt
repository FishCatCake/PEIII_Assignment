package com.example.pe_assignment.database

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.*
import com.example.pe_assignment.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException


class HpvViewModel (private val repository: HpvRepository) :
    ViewModel(), Observable {

    var HpvLiveData = MutableLiveData<List<HPV>>()

    @Bindable
    val reviewYear = MutableLiveData<Int?>()

    @Bindable
    val reviewMonth = MutableLiveData<Int?>()

    @Bindable
    val reviewDay = MutableLiveData<Int?>()

//    @Bindable
//    val firstVaccDate = MutableLiveData<Date?>()
//
//    @Bindable
//    val secondVaccDate = MutableLiveData<Date?>()
//
//    @Bindable
//    val thirdVaccDate = MutableLiveData<Date?>()
//
    fun hpv (){
        val reviewYear: Int = reviewYear.value!!
        val reviewMonth: Int = reviewMonth.value!!
        val reviewDay: Int = reviewDay.value!!
        val hpv = HPV(0,reviewYear,reviewMonth,reviewDay)
        insert(hpv)
    }

    fun register() {  // Empty field and validate username and password
        Log.i("eee", "reg func")
        if((reviewYear.value == null) ||
            (reviewMonth.value == null) ||
            (reviewDay.value == null)) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
                  // No existing record with the same username
                val reviewYear: Int = reviewYear.value!!
                val reviewMonth: Int = reviewMonth.value!!
                val reviewDay: Int = reviewDay.value!!
                val hpv = HPV(0,reviewYear,reviewMonth,reviewDay)
                insert(hpv)
                }
            }
        }
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

    private fun insert(hpv: HPV) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(hpv)
        }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}

class HpvViewModelFactory(private val repository: HpvRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HpvViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HpvViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}