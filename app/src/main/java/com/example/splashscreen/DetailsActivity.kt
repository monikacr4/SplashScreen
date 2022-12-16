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
import com.example.splashscreen.Model.Person
import com.example.splashscreen.R.*

class DetailsActivity : AppCompatActivity() {
    lateinit var detailsPerson: TextView
    lateinit var detailsAge: TextView
    lateinit var detailsOccupation: TextView

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    var isRemembered = false

    private var SHARED_PREF = "mypref"
    private var NAME= "name"
    private var AGE= "age"
    private var OCCUPATION= "occupation"


    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_details)

        detailsPerson=findViewById(R.id.detailsPerson)
        detailsAge=findViewById(R.id.detailsAge)
        detailsOccupation=findViewById(R.id.detailsOccupation)


        val person = intent.getSerializableExtra("PERSON") as Person

        detailsPerson.text = "Name entered : " + person.name
        detailsAge.text = "Age entered: "+ person.age
        detailsOccupation.text = "Occupation entered: "+ person.occupation

        sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        isRemembered=sharedPreferences.getBoolean("CHECKBOX", false)

        if(isRemembered){
            val intent = Intent(this,PreferenceActivity::class.java)
            startActivity(intent)
            finish()
        }
        val continueButton: Button
        continueButton = findViewById(R.id.continueButton)
        continueButton.setOnClickListener{
            val names = detailsPerson.text.toString()
            val ages = detailsAge.text.toString()
            val occupations = detailsOccupation.text.toString()

            val editor: SharedPreferences.Editor=sharedPreferences.edit()
            editor.putString(NAME,names)
            editor.putString(AGE,ages)
            editor.putString(OCCUPATION,occupations)
            editor.apply()

            Toast.makeText(this,"info saved",Toast.LENGTH_LONG).show()

            val intent = Intent(this,PreferenceActivity::class.java)
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