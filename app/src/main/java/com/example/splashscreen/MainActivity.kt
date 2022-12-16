package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.splashscreen.Model.Person
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var personName: TextInputEditText
    lateinit var personAge: TextInputEditText
    lateinit var personOccupation: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel = ViewModelProviders.of()

        personName = findViewById(R.id.personName)
        personAge= findViewById(R.id.personAge)
        personOccupation = findViewById(R.id.personOccupation)

        val button: Button
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val name = personName.text.toString()
            val age = personAge.text.toString().toIntOrNull()
            val occupation = personOccupation.text.toString()
            val person = Person(name,age,occupation)

            if(name.isEmpty()){
                personName.error = "name required"
                return@setOnClickListener
                
            }else if(age == null){
                personAge.error = "age required"
                Toast.makeText(this,"Please enter a number", Toast.LENGTH_LONG ).show()
                return@setOnClickListener
            }
            else if (occupation.isEmpty()){
                personOccupation.error = "occupation required"
                return@setOnClickListener
            }

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("PERSON", person)
            startActivity(intent)


        }

    }
    override fun onPause() {
        super.onPause()
        Log.d("Main", "onPause main Called")
    }

}



