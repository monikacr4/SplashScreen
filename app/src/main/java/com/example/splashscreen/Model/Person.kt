package com.example.splashscreen.Model

data class Person(
    val name: String,
    val age: Int?,
    val occupation: String
): java.io.Serializable // passes the data between activities through intents