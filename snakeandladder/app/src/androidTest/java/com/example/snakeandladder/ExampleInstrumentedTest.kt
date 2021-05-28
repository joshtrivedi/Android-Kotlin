package com.example.snakeandladder

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest : AppCompatActivity(){
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.snakeandladder", appContext.packageName)
    }
    var i:Int=0
    var p1step:Int=0
    var p2step:Int=0        
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstaceState)
        setContentView(R.layout.activity_main)
        p2.seOnClickListener {
            i=(1..4).random()
            Log.d("player-2",i.toString())
        }
        p1.setOnClickListener {
            if(flag==0) {

            }
        }
    }
}