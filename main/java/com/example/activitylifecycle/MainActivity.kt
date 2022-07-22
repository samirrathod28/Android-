package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var a1:Button
    lateinit var a2:Button
    lateinit var a3:Button
    lateinit var a4:Button
    lateinit var a5:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Toast.makeText(applicationContext,"Activity Created",Toast.LENGTH_LONG).show()

    }

    override fun onStart() {
        super.onStart()
        a1 = findViewById(R.id.b1)
        a1.setOnClickListener(){
            Toast.makeText(applicationContext,"Activity Started",Toast.LENGTH_LONG).show()
        }

    }

    override fun onStop() {
        super.onStop()
        a2 = findViewById(R.id.b2)
        a2.setOnClickListener(){
            Toast.makeText(applicationContext,"Activity stoped",Toast.LENGTH_LONG).show()
        }
    }

    override fun onPause() {
        super.onPause()
        a3 = findViewById(R.id.b3)
        a3.setOnClickListener(){
            Toast.makeText(applicationContext,"Activity Pause",Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        a4 = findViewById(R.id.b4)
        a4.setOnClickListener(){
            Toast.makeText(applicationContext,"Activity Resume",Toast.LENGTH_LONG).show()
        }


    }

    override fun onRestart() {
        super.onRestart()
        a5 = findViewById(R.id.b5)
        a5.setOnClickListener(){
            Toast.makeText(applicationContext,"Activity Restart",Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
            Toast.makeText(applicationContext,"Activity Destroy",Toast.LENGTH_LONG).show()

    }

}