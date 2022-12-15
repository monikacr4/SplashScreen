package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.splashscreen.Model.Person
import com.example.splashscreen.R.id.detailsOccupation

class DetailsActivity : AppCompatActivity() {
    lateinit var detailsPerson: TextView
    lateinit var detailsAge: TextView
    lateinit var detailsOccupation: TextView
//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detailsPerson=findViewById(R.id.detailsPerson)
        detailsAge=findViewById(R.id.detailsAge)
        detailsOccupation=findViewById(R.id.detailsOccupation)


        val person = intent.getSerializableExtra("PERSON") as Person

        detailsPerson.text = "Name entered : " + person.name
        detailsAge.text = "Age entered: "+ person.age
        detailsOccupation.text = "Ocupation entered: "+ person.occupation

    }
    override fun onPause() {
        super.onPause()
        Log.d("Main", "onPause Called")
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