package com.example.telephony

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    fun regValidator(phoneNumber: String): Boolean {
        val regex = Regex("^\\d{10}$")
        return regex.containsMatchIn(input = phoneNumber.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE),221)

        }
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),222)
        }
        btnCall.setOnClickListener{
            if(!regValidator(txtCall.text.toString())){
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var it1 = Intent(Intent.ACTION_CALL, Uri.parse("tel:+91"+txtCall.text.toString()))
            startActivity(it1)
        }
        btnMsg.setOnClickListener{
            if(!regValidator(txtCall.text.toString())){
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var sm = SmsManager.getDefault()
            sm.sendTextMessage(txtCall.text.toString(),null,msgBox.text.toString(),null,null)
        }
        btnWapp.setOnClickListener{
            if(!regValidator(txtCall.text.toString())){
                Toast.makeText(this, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var it3 = Intent(Intent.ACTION_VIEW)
            it3.setData(Uri.parse("https://wa.me/+91"+txtCall.text.toString()+"/?text="+msgBox.text.toString()))
            startActivity(it3)
        }
        /*
        btnMsg.setOnClickListener{
            var it2 = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:+91"+txtCall.text.toString()))
            it2.putExtra("sms_body",msgBox.text.toString())
            startActivity(it2)
        }*/



    }

}