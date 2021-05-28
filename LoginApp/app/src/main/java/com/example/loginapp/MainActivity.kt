package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = myDBMS(applicationContext)
        var tb = db.readableDatabase
        btnlogin.setOnClickListener(){
            var dt = arrayOf<String>(txtUsername.text.toString(),txtPassword.text.toString())
            var ds = tb.rawQuery("SELECT * FROM STUDENT WHERE UNAME = ? AND PASSWD = ?", dt)

            if(ds.moveToNext()){
                startActivity(Intent(this,WelcomePage::class.java).putExtra("user",txtUsername.toString()))
            }else{
                Toast.makeText(this,"Invalid Username and Password",Toast.LENGTH_LONG).show()
            }
        }





    }
}