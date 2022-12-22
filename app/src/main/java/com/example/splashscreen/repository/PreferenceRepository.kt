package com.example.splashscreen.repository

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.splashscreen.model.Person


class PreferenceRepository(val context:Context) {
    private val nameKey: String = "name"
    private val ageKey: String = "age"
    private val occupationKey: String = "occupation"

    /*const should be used in companion object or at higher level. it cant be initialised at
    * runtime so function or variables should not be assigned to const
    * val is used when we are assigning it with some value at run time*/
    companion object {
        private const val sharedPre = "my-pref"
    }

    //MODE_PRIVATE:Mode of storing data = only this application can read this sharedPreference file
//sharedPreference is an interface
//MODE_APPEND is used while reading the data from the SharedPre file.
    fun saveStringInPref(details: Person) {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(Companion.sharedPre, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(nameKey, details.name)
        editor.putString(ageKey, details.age)
        editor.putString(occupationKey, details.occupation)
        editor.apply()
    }

    fun getFromPref(): Person {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(sharedPre, MODE_PRIVATE)
        val namePerson = sharedPref.getString(nameKey, null)
        val agePerson = sharedPref.getString(ageKey, null)
        val occupationPerson = sharedPref.getString(occupationKey, null)
        return Person(name = namePerson, age = agePerson, occupation = occupationPerson)
    }
}









//    fun storeDetail(context: Context):String?{
//
//        val sharedPref: SharedPreferences =
//            context.getSharedPreferences(SHARED_PREF, android.content.Context.MODE_PRIVATE)
//        val personName = sharedPreferences.getString(NAME,null)
//        val personAge = sharedPreferences.getString(AGE,null)
//        val personOccupation = sharedPreferences.getString(OCCUPATION,null)
//
//        return sharedPref.getString(personName,null)
//


