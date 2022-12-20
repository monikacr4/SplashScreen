package com.example.splashscreen

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.splashscreen.Model.PreferenceVm
import androidx.activity.viewModels


class PreferenceActivity : AppCompatActivity() {
    private lateinit var personsName: TextView
    private lateinit var personsAge: TextView
    private lateinit var personsOccupation: TextView

    val viewModel by viewModels<PreferenceVm>()

    private val SHARED_PREF = "mypref"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        personsName = findViewById(R.id.detailsPersons)
        personsAge= findViewById(R.id.detailsAges)
        personsOccupation = findViewById(R.id.detailsOccupations)

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE)


        viewModel.getDetails(details = Details())

        viewModel.personDetails.observe(this){

            personsName.text = it?.name
            personsAge.text = it?.age
            personsOccupation.text=it?.occupation

        }
    }
}