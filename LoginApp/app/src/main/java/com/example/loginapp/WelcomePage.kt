package com.example.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome_page.*

class WelcomePage : AppCompatActivity() {
    private var rollno: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
        textView2.text = intent.getStringExtra("username").toString()
        rollno = intent.getStringExtra("user").toString()
        //textView2.setText(intent.getStringExtra("username").toString())
    }
}