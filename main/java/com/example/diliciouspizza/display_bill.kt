package com.example.diliciouspizza

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_display_bill.*

class display_bill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_bill)


        val i =intent
        val data=i.getStringExtra("bill")
        dis_bill.text = data

        exit_btn.setOnClickListener{
            var alert= AlertDialog.Builder(this)
            alert.setTitle("Do You Want to Exit?")
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
        ordr_agn.setOnClickListener(){
            startActivity(Intent(this,menuactivity::class.java))
        }
    }
}