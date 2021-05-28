package com.example.locationapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_DENIED)
            && (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_DENIED))
        {
            ActivityCompat.requestPermissions(this, arrayOf( Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION),7)
        }

        var lm: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var lp = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        var l = LocationListener { p0 -> myLocation(p0) }
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,10.0f,l)

    }

    private fun myLocation(p0: Location) {
        var gc = Geocoder(this, Locale.getDefault())
        var addressList = gc.getFromLocation(p0.latitude,p0.longitude,4)
        var latestAddress = addressList.get(0)
        var str=""
        for(i in 0..3)
        {
            str = str+addressList.get(i).getAddressLine(0).toString()+"\n"
        }
        txtLocations.setText(str)
        txtLastLocation.setText(latestAddress.getAddressLine(0))
    }
}