package com.example.login

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class register_user : AppCompatActivity() {

    private lateinit var pwd:EditText
    private lateinit var cpwd:EditText
    private lateinit var rg:Button
    private lateinit var nam:EditText
    private lateinit var mob:EditText
    private lateinit var lin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window. FEATURE_NO_TITLE)
        setContentView(R.layout.activity_register_user)

        this.window. setFlags(WindowManager. LayoutParams. FLAG_FULLSCREEN, WindowManager. LayoutParams. FLAG_FULLSCREEN)

        pwd = findViewById(R.id.psd)
        cpwd = findViewById(R.id.cfm_psd)
        rg = findViewById(R.id.rgst_btn)
        nam = findViewById(R.id.nm)
        mob = findViewById(R.id.mobile_no)
        lin = findViewById(R.id.log_in)

        lin.setOnClickListener {
            startActivity(Intent(this,login::class.java))
        }

        rg.setOnClickListener{

            val pass = pwd.text.toString()
            val cpass = cpwd.text.toString()
            val n = nam.text.toString()
            val m = mob.text.toString()

            when {
                pass != cpass -> {
                    cpwd.error = "Enter Password Same as Above"
                }
                n.isEmpty() -> {
                    nam.error = "Enter Name"
                }
                m.isEmpty() -> {
                    mob.error = "Enter Name"
                }
                pass.isEmpty() -> {
                    pwd.error = "Enter Password"
                }
                cpass.isEmpty() -> {
                    cpwd.error = "Confirm Password"
                }
                else -> {

                    Toast.makeText(applicationContext,"Registration Success",Toast.LENGTH_LONG).show()
                }
            }

        }


    }
    override fun onBackPressed() {

        val alert= AlertDialog.Builder(this)
        alert.setTitle("Are you sure?")
        alert.setPositiveButton("YES") { dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        }
        alert.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()

        }
        alert.show()

    }
}