package com.example.frgmt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity() {

    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn=findViewById(R.id.btn1)

        btn.setOnClickListener(){
            var b=fragment1()
            var fm:FragmentManager=supportFragmentManager
            var ft:FragmentTransaction=fm.beginTransaction()
            ft.replace(R.id.frmid,b).commit()

        }
    }
}