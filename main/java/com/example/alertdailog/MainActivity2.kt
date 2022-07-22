package com.example.alertdailog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var t:TextView
    lateinit var t1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        t = findViewById(R.id.tx1)
        t1 = findViewById(R.id.tx2)

        val i =intent
        val data=i.getStringExtra("name")
        val data1=i.getStringExtra("pass")
        t.text = data
        t1.text = data1

    }
}