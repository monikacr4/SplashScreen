package com.example.splashscreen.Model

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.widget.TextView
import com.example.splashscreen.Details


class PreferenceRepository {

    var SHARED_PREF = "mypref"


    fun saveStringInPref(context: Context, details: Details) {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(SHARED_PREF, MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(details.nameKey, details.name)
        editor.putString(details.ageKey, details.age)
        editor.putString(details.occupationKey, details.occupation)
        editor.apply()
    }

    fun getFromPref(context: Context, details: Details): Details? {
        val sharedPref: SharedPreferences =
            context.getSharedPreferences(SHARED_PREF, MODE_PRIVATE)
        val namePerson = sharedPref.getString(details.nameKey, null)
        val agePerson = sharedPref.getString(details.ageKey, null)
        val occupationPerson = sharedPref.getString(details.occupationKey, null)
        val Detail = Details(name =namePerson, age = agePerson,occupation = occupationPerson)
        return Detail
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
//    }

}