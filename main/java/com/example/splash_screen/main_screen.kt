package com.example.splash_screen

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog

class main_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window. FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main_screen)
        this. getWindow(). setFlags(WindowManager. LayoutParams. FLAG_FULLSCREEN, WindowManager. LayoutParams. FLAG_FULLSCREEN);
    }

    override fun onBackPressed() {

        var alert= AlertDialog.Builder(this)
        alert.setTitle("Are you sure?")
        alert.setPositiveButton("YES",{
                dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alert.setNegativeButton("No",{
                dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()

        })
        alert.show()

    }
}