package com.example.splashscreen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import com.example.splashscreen.Model.PreferenceVm
import com.example.splashscreen.R.layout

class DetailsActivity : AppCompatActivity() {
    private lateinit var detailsPerson: TextView
    private lateinit var detailsAge: TextView
    private lateinit var detailsOccupation: TextView

    //Why lateint
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    companion object {
        private const val SHARED_PREF = "mypref"
        private var NAME = "name"
        private var AGE = "age"
        private var OCCUPATION = "occupation"
    }
    //companion object, what is a companion object


    //Why lazy, what is ment by keyword, what is inline function
    private val viewModel by viewModels<PreferenceVm>()


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_details)

        // Can this be local?
        detailsPerson = findViewById(R.id.detailsPerson)
        detailsAge = findViewById(R.id.detailsAge)
        detailsOccupation = findViewById(R.id.detailsOccupation)

        //Checj for null, cast check
        val person = intent.getSerializableExtra("PERSON") as Person

        //Move this to strings
        detailsPerson.text = "Name entered : " + person.name
        detailsAge.text = "Age entered: " + person.age
        detailsOccupation.text = "Occupation entered: " + person.occupation


        sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        //Can be local
        editor = sharedPreferences.edit()

        val continueButton: Button = findViewById(R.id.continueButton)
        continueButton.setOnClickListener {
            val names = detailsPerson.text.toString()
            val ages = detailsAge.text.toString()
            val occupations = detailsOccupation.text.toString()

            viewModel.saveDetails(
                details = Details(
                    name = names, nameKey = NAME,
                    age = ages, ageKey = AGE,
                    occupation = occupations, occupationKey = OCCUPATION
                )
            )
//            val editor: SharedPreferences.Editor=sharedPreferences.edit()
//            editor.putString(NAME,names)
//            editor.putString(AGE,ages)
//            editor.putString(OCCUPATION,occupations)
//            editor.apply()

            Toast.makeText(this, "info saved", Toast.LENGTH_LONG).show()

            val intent = Intent(this, PreferenceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onStop() {
        super.onStop()
        Log.d("Main", "onStop Called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main", "onDestroy Called")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("Main", "onRestart Called")
    }
}
