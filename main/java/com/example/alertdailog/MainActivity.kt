package com.example.alertdailog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.click)

        btn.setOnClickListener(){

            val layout = LayoutInflater.from(applicationContext)
            val view = layout.inflate(R.layout.activity_custom_dailog,null)
            val dailog = AlertDialog.Builder(this)
            val b2=view.findViewById<ImageView>(R.id.close)

            b2.setOnClickListener(){

                finish()

            }

            dailog.setView(view)
            dailog.show()


        }

    }
}

