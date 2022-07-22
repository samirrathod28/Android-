package com.example.materialui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    lateinit var login:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        login = findViewById(R.id.lgn)
        login.setOnClickListener(){

            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

    }
}