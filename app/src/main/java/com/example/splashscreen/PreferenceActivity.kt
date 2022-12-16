package com.example.splashscreen

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class PreferenceActivity : AppCompatActivity() {
    private lateinit var personsName: TextView
    private lateinit var personsAge: TextView
    private lateinit var personsOccupation: TextView

    private var SHARED_PREF = "mypref"
    private var NAME= "name"
    private var AGE= "age"
    private var OCCUPATION= "occupation"

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        personsName = findViewById(R.id.detailsPersons)
        personsAge= findViewById(R.id.detailsAges)
        personsOccupation = findViewById(R.id.detailsOccupations)

        sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE)
        val personName = sharedPreferences.getString(NAME,null)
        val personAge = sharedPreferences.getString(AGE,null)
        val personOccupation = sharedPreferences.getString(OCCUPATION,null)

        personsName.text = personName
        personsAge.text = personAge
        personsOccupation.text = personOccupation
    }
}