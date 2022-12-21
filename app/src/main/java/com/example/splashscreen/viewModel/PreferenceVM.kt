package com.example.splashscreen.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.splashscreen.model.Details
import com.example.splashscreen.repository.PreferenceRepository

class PreferenceVM(val repository: PreferenceRepository) : ViewModel() {

    //What is the mutableLivedata, it should be private
    val personDetails = MutableLiveData<Details?>()
//    val personAge = MutableLiveData<String?>()
//    val personOccupation = MutableLiveData<String?>()

    fun saveDetails(details: Details) {
        repository.saveStringInPref(details)
    }


    fun getDetails(details: Details) {
        personDetails.value = repository.getFromPref(details = details)

//        personAge.value = repository.getFromPref(context, "age")
//        personOccupation.value = repository.getFromPref(context, "occupation")
    }
}
