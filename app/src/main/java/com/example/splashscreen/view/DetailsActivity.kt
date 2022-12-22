package com.example.splashscreen.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.splashscreen.model.Person
import com.example.splashscreen.R
import com.example.splashscreen.viewModel.PreferenceVM
import com.example.splashscreen.R.layout
import com.example.splashscreen.repository.PreferenceRepository
import com.example.splashscreen.viewModel.PreferenceVMFactory

class DetailsActivity : AppCompatActivity(), View.OnClickListener {
    //Why late init - we can declare the variable without assigning value
    private lateinit var detailsName: TextView
    private lateinit var detailsAge: TextView
    private lateinit var detailsOccupation: TextView

    private lateinit var sharedPreferences: SharedPreferences
    companion object {
        private const val SHARED_PREF = "my-pref"
    }
    /*companion object, what is a companion object
    * its the keyword used to implement the class
    * we can directly access the fields without calling the object name
    * without creating an instance of the class we can access the fields in companion object
    * companion object provides same to every instance created*/

    //Why lazy, what is meant by keyword, what is inline function
    //lazy- until the variable is used memory will not be allocated and it can be initialised whenever needed
    //keyword - predefined words
    //private val viewModel by viewModels<PreferenceVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_details)

        // Can this be local?
        detailsName = findViewById(R.id.detailsPerson)
        detailsAge = findViewById(R.id.detailsAge)
        detailsOccupation = findViewById(R.id.detailsOccupation)

        val person = intent.getSerializableExtra("PERSON") as Person

        (getString(R.string.name_entered) + person.name).also { detailsName.text = it }
        (getString(R.string.age_entered)+ person.age).also { detailsAge.text = it }
        (getString(R.string.occupation_entered) + person.occupation).also { detailsOccupation.text = it }

        sharedPreferences = getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

        val continueButton: Button = findViewById(R.id.continueButton)
        continueButton.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        val names = detailsName.text.toString()
        val ages = detailsAge.text.toString()
        val occupations = detailsOccupation.text.toString()

        val viewModel: PreferenceVM = ViewModelProvider(this,
            PreferenceVMFactory(repository = PreferenceRepository(context = application))
        )[PreferenceVM::class.java]
        viewModel.saveDetails(
            details = Person(
                name = names,
                age = ages,
                occupation = occupations
            )
        )
        Toast.makeText(this, "info saved", Toast.LENGTH_LONG).show()
        val intent = Intent(this, PreferenceActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStop() {
        super.onStop()
        Log.d(MAIN, "onStop Called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(MAIN, "onDestroy Called")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(MAIN, "onRestart Called")
    }
}
