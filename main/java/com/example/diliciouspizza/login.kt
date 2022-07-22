package com.example.diliciouspizza

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.CompoundButton
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        show_pass.setOnCheckedChangeListener(this)
        btn_login.setOnClickListener {
            val a = mn.text.toString()
            val b = pass.text.toString()
            val m = 7984666909
            val p = "samir"

            if (a.isBlank() && b.isBlank()) {
                mn.error = "Enter Mobile Number"
                pass.error = "Enter Password"
            }
            if (a.isBlank()) {
                mn.error = "Enter Mobile Number"
            }
            if (b.isBlank()) {
                pass.error = "Enter Password"
            }
            if(a == m.toString() && b == p){
                startActivity(Intent(this,menuactivity::class.java))
            }
            else{
                val alert= AlertDialog.Builder(this)
                alert.setTitle("Enter Valid Input")
                alert.setPositiveButton("Ok") { dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.dismiss()

                }
                alert.show()
            }


        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if(show_pass.isChecked){

            pass.transformationMethod = HideReturnsTransformationMethod.getInstance()

        }
        else{
            pass.transformationMethod = PasswordTransformationMethod.getInstance()
        }
    }
}


