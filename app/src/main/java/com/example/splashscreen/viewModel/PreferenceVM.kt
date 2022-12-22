package com.example.splashscreen.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.splashscreen.model.Person
import com.example.splashscreen.repository.PreferenceRepository

class PreferenceVM(private val repository: PreferenceRepository) : ViewModel() {
    /*
    * What is the mutableLivedata, it should be private
    * LiveData is a part of the architecture patterns.It holds the data and observes view and updates it when its active
    * Mutable live data is a class that extends the livedata class that gives setValue() and postValue() methods which are used to update the values
    * */
    val personDetails = MutableLiveData<Person?>()

    fun saveDetails(details: Person) {
        repository.saveStringInPref(details)
    }

    fun getDetails() {
        personDetails.value = repository.getFromPref()
    }
}
