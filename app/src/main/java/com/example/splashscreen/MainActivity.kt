package com.example.splashscreen

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var personName: TextInputEditText
    lateinit var personAge: TextInputEditText
    lateinit var personContact: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personName = findViewById(R.id.personName)
        personAge= findViewById(R.id.personAge)
        personContact = findViewById(R.id.contactNumber)

        val button: Button
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val name = personName.text.toString()
            val age = personAge.text.toString()
            val contact = personContact.text.toString()

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.NAME, name)
            intent.putExtra(DetailsActivity.AGE, age)
            intent.putExtra(DetailsActivity.CONTACT, contact)
            startActivity(intent)

        }
    }

}



