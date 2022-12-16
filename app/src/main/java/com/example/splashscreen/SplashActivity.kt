package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log

class SplashActivity : AppCompatActivity() {
    var checkBackPressed : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            if (!checkBackPressed == true) {
                startActivity(intent)
                finish()
            }
        },5000)
        Log.d("Main", "onCreated")

    }

    override fun onBackPressed() {
        if(checkBackPressed== true){
            finish()
        }
        //super.onBackPressed()
    }
    override fun onPause() {
        super.onPause()
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main", "onStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main", "onResume Called")
    }

}