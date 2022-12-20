package com.example.splashscreen.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.splashscreen.Details
import com.example.splashscreen.Person

class PreferenceVm(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext


    //What is the mutableLivedata, it should be private
    val personDetails = MutableLiveData<Details?>()
//    val personAge = MutableLiveData<String?>()
//    val personOccupation = MutableLiveData<String?>()
    var repository = PreferenceRepository()

    fun saveDetails(details: Details) {
        repository.saveStringInPref(context, details)
    }


    fun getDetails(details: Details) {
        personDetails.value = repository.getFromPref(context, details = details)

//        personAge.value = repository.getFromPref(context, "age")
//        personOccupation.value = repository.getFromPref(context, "occupation")
    }
}
