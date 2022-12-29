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

class HpvViewModel (private val repository: HpvRepository) : ViewModel(){
    private val _reviewyear = MutableLiveData<String?>("")
    val reviewyear: MutableLiveData<String?> = _reviewyear
    private val _reviewmonth = MutableLiveData<String?>("")
    val reviewmonth: MutableLiveData<String?> = _reviewmonth
    private val _reviewdate = MutableLiveData<String?>("")
    val reviewdate: MutableLiveData<String?> = _reviewdate

    private val _dose1year = MutableLiveData<String?>("")
    val dose1year: MutableLiveData<String?> = _dose1year
    private val _dose1month = MutableLiveData<String?>("")
    val dose1month: MutableLiveData<String?> = _dose1month
    private val _dose1date = MutableLiveData<String?>("")
    val dose1date: MutableLiveData<String?> = _dose1date

    private val _dose2year = MutableLiveData<String?>("")
    val dose2year: MutableLiveData<String?> = _dose2year
    private val _dose2month = MutableLiveData<String?>("")
    val dose2month: MutableLiveData<String?> = _dose2month
    private val _dose2date = MutableLiveData<String?>("")
    val dose2date: MutableLiveData<String?> = _dose2date

    private val _dose3year = MutableLiveData<String?>("")
    val dose3year: MutableLiveData<String?> = _dose3year
    private val _dose3month = MutableLiveData<String?>("")
    val dose3month: MutableLiveData<String?> = _dose3month
    private val _dose3date = MutableLiveData<String?>("")
    val dose3date: MutableLiveData<String?> = _dose3date


    fun setReviewYear(review_year: String) {
        _reviewyear.value = review_year
    }

    fun setReviewMonth(review_month: String) {
        _reviewmonth.value = review_month
    }
    fun setReviewDate(review_date: String) {
        _reviewdate.value = review_date
    }

    fun setDose1Year(dose1_year: String) {
        _dose1year.value = dose1_year
    }

    fun setDose1Month(dose1_month: String) {
        _dose1month.value = dose1_month
    }
    fun setDose1Date(dose1_date: String) {
        _dose1date.value = dose1_date
    }

    fun setDose2Year(dose2_year: String) {
        _dose2year.value = dose2_year
    }

    fun setDose2Month(dose2_month: String) {
        _dose2month.value = dose2_month
    }
    fun setDose2Date(dose2_date: String) {
        _dose3date.value = dose2_date
    }

    fun setDose3Year(dose3_year: String) {
        _dose3year.value = dose3_year
    }

    fun setDose3Month(dose3_month: String) {
        _dose3month.value = dose3_month
    }
    fun setDose3Date(dose3_date: String) {
        _dose3date.value = dose3_date
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
            (_reviewyear.value == null)||
            (_reviewmonth.value == null)||
            (_reviewdate.value == null)||
            (_dose1year.value == null)||
            (_dose1month.value == null)||
            (_dose1date.value == null)||
            (_dose2year.value == null)||
            (_dose2month.value == null)||
            (_dose2date.value == null)||
            (_dose3year.value == null)||
            (_dose3month.value == null)||
            (_dose3date.value == null)
        ) {
            _errorToast.value = true
        } else {  // register
            uiScope.launch {
//                val userInfo = repository.getUserCredential(_account.value.toString())
//                if(userInfo == null) {  // No existing record with the same username
                val reviewyear: String = _reviewyear.value.toString()
                val reviewmonth: String = _reviewmonth.value.toString()
                val reviewdate: String = _reviewdate.value.toString()

                val dose1year: String = _dose1year.value.toString()
                val dose1month: String = _dose1month.value.toString()
                val dose1date: String = _dose1date.value.toString()

                val dose2year: String = _dose2year.value.toString()
                val dose2month: String = _dose2month.value.toString()
                val dose2date: String = _dose2date.value.toString()

                val dose3year: String = _dose3year.value.toString()
                val dose3month: String = _dose3month.value.toString()
                val dose3date: String = _dose3date.value.toString()

                val hpv = HPV(0,reviewyear,reviewmonth,reviewdate,dose1year,dose1month,dose1date,dose2year,dose2month,dose2date,dose3year,dose3month,dose3date,"1")
                insert(hpv)
                _errorToastUserName.value = false
                _navigateto.value = true  // already inserted
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


    private fun insert(hpv: HPV) : Job =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(hpv)
        }

}