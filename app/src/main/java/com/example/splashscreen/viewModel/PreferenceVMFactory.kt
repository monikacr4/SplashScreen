package com.example.splashscreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.repository.PreferenceRepository

//what is view model provider and factory
/*factory is an interface that as create method and create the instance of view model
* Provider is an utility class that provides us the ViewModel scope to create the object*/
class PreferenceVMFactory(val repository: PreferenceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PreferenceVM(repository) as T
    }
}