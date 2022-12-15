package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.splashscreen.R.id.detailsOccupation

class DetailsActivity : AppCompatActivity() {
    lateinit var detailsPerson: TextView
    lateinit var detailsAge: TextView
    lateinit var detailsOccupation: TextView
    companion object{
        const val NAME = "NAME"
        const val AGE = "AGE"
        const val OCCUPATION = "OCCUPATION"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detailsPerson=findViewById(R.id.detailsPerson)
        detailsAge=findViewById(R.id.detailsAge)
        detailsOccupation=findViewById(R.id.detailsOccupation)


        val name = intent.getStringExtra(NAME)
        val age = intent.getStringExtra(AGE)
        val occupation = intent.getStringExtra(OCCUPATION)

        detailsPerson.text = "Name entered " + name
        detailsAge.text = "Age entered"+ age
        detailsOccupation.text = "Ocupation entered "+ occupation

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