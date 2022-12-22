package com.example.splashscreen.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.splashscreen.model.Person
import com.example.splashscreen.R
import com.example.splashscreen.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var personName: TextInputEditText? = null
    private lateinit var personAge: TextInputEditText
    private lateinit var personOccupation: EditText
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater) //instantiate layout XML file into its corresponding View objects
        setContentView(binding.root)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val name = binding.personName.text.toString()
            val age = binding.personAge.text.toString()
            val occupation = binding.personOccupation.text.toString()
            val person = Person(name, age, occupation)

            if (name.isEmpty()) {
                personName?.error = "name required"
                return@setOnClickListener
            } else if (age.isEmpty()) {
                personAge.error = "age required"
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else if (occupation.isEmpty()) {
                personOccupation.error = "occupation required"
                return@setOnClickListener
            }

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("PERSON", person)
            startActivity(intent)
        }
    }
}
