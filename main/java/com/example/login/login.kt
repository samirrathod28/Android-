package com.example.login

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class login : AppCompatActivity() {

   private lateinit var reg:TextView
   private lateinit var mob:EditText
   private lateinit var pass:EditText
   private lateinit var btn:Button

    @Suppress("EqualsBetweenInconvertibleTypes")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window. FEATURE_NO_TITLE)
        setContentView(R.layout.activity_login)
        this.window. setFlags(WindowManager. LayoutParams. FLAG_FULLSCREEN, WindowManager. LayoutParams. FLAG_FULLSCREEN)

        mob=findViewById(R.id.et1)
        pass=findViewById(R.id.et2)
        reg =findViewById(R.id.register_txt)
        btn=findViewById(R.id.lgn)

        reg.setOnClickListener{

            startActivity(Intent(this,register_user::class.java))
        }

        btn.setOnClickListener{

            val mb = mob.text.toString()
            val ps = pass.text.toString()

            if (mb.isEmpty()&&ps.isEmpty()){

                mob.error = "enter mobile number"
                pass.error="enter Password"
            }
            else if (mb.isEmpty()){
                mob.error = "enter mobile number"
            }
            else if(ps.isEmpty()){
                pass.error = "enter password"
            }
            else if(mb==ps){
                Toast.makeText(applicationContext,"Default login success",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(applicationContext, "Enter Valid Details", Toast.LENGTH_SHORT).show()
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