package com.example.splashscreen.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.model.Details
import com.example.splashscreen.model.Person
import com.example.splashscreen.R
import com.example.splashscreen.viewModel.PreferenceVM
import com.example.splashscreen.R.layout
import com.example.splashscreen.repository.PreferenceRepository

private const val SHARED_PREF = "mypref"
class DetailsActivity : AppCompatActivity() {
    private lateinit var detailsPerson: TextView
    private lateinit var detailsAge: TextView
    private lateinit var detailsOccupation: TextView

    //Why lateint - we can declare the variable without assigning value
    private lateinit var sharedPreferences: SharedPreferences
    //private lateinit var editor: SharedPreferences.Editor

    companion object {
        private const val SHARED_PREF = "mypref"
        private var NAME = "name"
        private var AGE = "age"
        private var OCCUPATION = "occupation"
    }
    //companion object, what is a companion object


    //Why lazy, what is ment by keyword, what is inline function
    //lazy- until the variable is used memory will not be allocated and it can be iitialised whenevr needed
    //keyword - predefined words
    //private val viewModel by viewModels<PreferenceVM>()


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
        "@string/name_entered: ${person.name}".also { detailsPerson.text = it }
        "@string/age_entered: ${person.age}".also { detailsAge.text = it }
        "@string/occupation_entered: ${person.occupation}".also { detailsOccupation.text = it }


        sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        //Can be local
        //editor = sharedPreferences.edit()

        val continueButton: Button = findViewById(R.id.continueButton)
        continueButton.setOnClickListener {
            val names = detailsPerson.text.toString()
            val ages = detailsAge.text.toString()
            val occupations = detailsOccupation.text.toString()

            val viewModel: PreferenceVM = ViewModelProvider(this,
                DetailsVMFactory(repository = PreferenceRepository(context = application))
            )[PreferenceVM::class.java]

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
