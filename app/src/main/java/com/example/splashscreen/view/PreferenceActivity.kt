package com.example.splashscreen.view

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.splashscreen.viewModel.PreferenceVM
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.model.Details
import com.example.splashscreen.R
import com.example.splashscreen.repository.PreferenceRepository
import com.example.splashscreen.viewModel.PreferenceVMFactory


class PreferenceActivity : AppCompatActivity() {
    private lateinit var personsName: TextView
    private lateinit var personsAge: TextView
    private lateinit var personsOccupation: TextView

    //private val viewModel by viewModels<PreferenceVM>()

    private val sharedPref = "my-pref"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        personsName = findViewById(R.id.detailsPersons)
        personsAge= findViewById(R.id.detailsAge)
        personsOccupation = findViewById(R.id.detailsOccupations)

        sharedPreferences = getSharedPreferences(sharedPref, MODE_PRIVATE)
        val viewModel: PreferenceVM = ViewModelProvider(this,PreferenceVMFactory(repository = PreferenceRepository(context = application)))
            .get(PreferenceVM::class.java)

        viewModel.getDetails(details = Details())

        viewModel.personDetails.observe(this){
            personsName.text = it?.name
            personsAge.text = it?.age
            personsOccupation.text=it?.occupation

        }
    }
}