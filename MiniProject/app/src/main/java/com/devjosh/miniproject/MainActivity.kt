package com.devjosh.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        //window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //Delay for SplashScreen

        Handler().postDelayed({
            //start landing page activity
            startActivity(Intent(applicationContext,LandingPage::class.java))
        },4000)
    }
}