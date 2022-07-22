package com.example.materialui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var rgstr:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rgstr = findViewById(R.id.register)
        rgstr.setOnClickListener(){

            val i = Intent(this,RegisterActivity::class.java)
            startActivity(i)
        }
    }
}