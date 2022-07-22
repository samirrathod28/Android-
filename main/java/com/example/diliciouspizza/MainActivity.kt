@file:Suppress("DEPRECATION")

package com.example.diliciouspizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window. FEATURE_NO_TITLE)
        this. getWindow(). setFlags(WindowManager. LayoutParams. FLAG_FULLSCREEN, WindowManager. LayoutParams. FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        

        Handler().postDelayed({

            startActivity(Intent(this, login::class.java))

        }, 2000)

    }
}