package com.example.splashscreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.repository.PreferenceRepository

//what is viewmodel provide and factory
class PreferenceVMFactory(val repository: PreferenceRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PreferenceVM(repository) as T
    }
}