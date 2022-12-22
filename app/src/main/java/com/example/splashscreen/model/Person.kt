package com.example.splashscreen.model

data class Person(
    val name: String?,
    val age: String?,
    val occupation: String? = null
): java.io.Serializable // passes the data between activities through intents