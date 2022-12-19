package com.example.splashscreen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.splashscreen.Model.PreferenceRepository

class DetailsVM(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    var repository= PreferenceRepository()

    fun saveDetails(details: Details) {
        repository.saveStringInPref(context, details)
    }

}