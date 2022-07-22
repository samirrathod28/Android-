package com.example.splash_screen

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
        setContentView(R.layout.activity_main)
        this. getWindow(). setFlags(WindowManager. LayoutParams. FLAG_FULLSCREEN, WindowManager. LayoutParams. FLAG_FULLSCREEN);
        Handler().postDelayed(Runnable {

            startActivity(Intent(this,main_screen::class.java))
        },2000)


    }
}