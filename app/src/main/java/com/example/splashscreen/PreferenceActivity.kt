package com.example.splashscreen

import android.app.Application
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.Model.PreferenceRepository
import com.example.splashscreen.Model.PreferenceVm
import androidx.activity.viewModels


class PreferenceActivity : AppCompatActivity() {
    private lateinit var personsName: TextView
    private lateinit var personsAge: TextView
    private lateinit var personsOccupation: TextView

    val viewModel by viewModels<PreferenceVm>()

    private var SHARED_PREF = "mypref"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)


        personsName = findViewById(R.id.detailsPersons)
        personsAge= findViewById(R.id.detailsAges)
        personsOccupation = findViewById(R.id.detailsOccupations)

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE)


        viewModel.getdetails()

        viewModel.personName.observe(this){

                personsName.text = it
        }
        viewModel.personAge.observe(this){
            if(it != null) {
                personsAge.text = it
            }
        }
        viewModel.personOccupation.observe(this){
                personsOccupation.text = it
        }

    }
}