package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class DetailsActivity : AppCompatActivity() {
    lateinit var detailsPerson: TextView
    lateinit var detailsAge: TextView
    lateinit var detailsContact: TextView
    companion object{
        const val NAME = "NAME"
        const val AGE = "AGE"
        const val CONTACT = "CONTACT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        detailsPerson=findViewById(R.id.detailsPerson)
        detailsAge=findViewById(R.id.detailsAge)
        detailsContact=findViewById(R.id.detailsContact)


        val name = intent.getStringExtra(NAME)
        val age = intent.getStringExtra(AGE)
        val contact = intent.getStringExtra(CONTACT)

        detailsPerson.text = "Hi " + name
        detailsAge.text = "Your Age is "+ age
        detailsContact.text = "Your Contact Number is "+ contact

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