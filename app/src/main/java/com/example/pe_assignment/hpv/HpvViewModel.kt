package com.example.pe_assignment.hpv


import android.provider.SyncStateContract.Helpers.insert
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

    @Bindable
    val reviewTime = MutableLiveData<Date?>()

    @Bindable
    val firstDose = MutableLiveData<Date?>()

    @Bindable
    val secondDose = MutableLiveData<Date?>()

    @Bindable
    val thirdDose = MutableLiveData<Date?>()

    fun setReviewDate(reviewdate: Date) {
        reviewTime.value = reviewdate
    }

    private val _navigatetoRegister = MutableLiveData<Boolean>()
    val navigatetoRegister: LiveData<Boolean>
        get() = _navigatetoRegister  // if it is true, then we navigate to the Signup/Register screen

    private val _errorToast = MutableLiveData<Boolean>()
    val errorToast: LiveData<Boolean>
        get() = _errorToast

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun Date() {
        if(reviewTime.value == null ||
            firstDose.value == null||
            secondDose.value == null||
            thirdDose.value == null    ) {
            _errorToast.value = true
        } else {
            uiScope.launch {
                val reviewTime: Date = reviewTime.value!!
                val firstDose: Date = firstDose.value!!
                val secondDose: Date = secondDose.value!!
                val thirdDose: Date = thirdDose.value!!
                val hpv = HPV(0,reviewTime,firstDose,secondDose,thirdDose)
                insert(hpv)

            }

    }

    fun signUp() {
        _navigatetoRegister.value = true
    }

    fun doneNavigatingRegister() {
        _navigatetoRegister.value = false
    }
}

    private fun insert(hpv: HPV) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(hpv)
        }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}