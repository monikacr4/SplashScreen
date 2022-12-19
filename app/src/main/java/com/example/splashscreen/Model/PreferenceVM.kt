package com.example.splashscreen.Model

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.splashscreen.Details
import java.util.jar.Attributes.Name

class PreferenceVm(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext


    val personName = MutableLiveData<String?>()
    val personAge = MutableLiveData<String?>()
    val personOccupation = MutableLiveData<String?>()
    var repository= PreferenceRepository()

    fun saveDetails(details:Details){
        repository.saveStringInPref(context,details)
    }


    fun getdetails(){
        personName.value = repository.getFromPref(context,"name")
        personAge.value = repository.getFromPref(context,"age")
        personOccupation.value = repository.getFromPref(context,"occupation")

    }

}