package com.example.flags

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tv1: TextView
    private lateinit var tv2:TextView
    private lateinit var tv3:TextView
    private lateinit var i:ImageView
    private lateinit var a:ImageView
    private lateinit var c:ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        tv3=findViewById(R.id.tv3)
        i=findViewById(R.id.ind)
        a=findViewById(R.id.aus)
        c=findViewById(R.id.can)

        tv1.setOnClickListener(){

            val i =Intent(this, ind::class.java)
            startActivity(i)


        }

        tv2.setOnClickListener(){

            val i =Intent(this,aus::class.java)
            startActivity(i)



        }

        tv3.setOnClickListener(){

            val i =Intent(this,can::class.java)
            startActivity(i)



        }

        i.setOnClickListener(){

            val url="https://www.india.gov.in"
            var i =Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }

        a.setOnClickListener(){

            val url="https://www.australia.gov.au"
            var a =Intent(Intent.ACTION_VIEW)
            a.setData(Uri.parse(url))
            startActivity(a)
        }

        c.setOnClickListener(){

            val url="https://www.canada.ca"
            var c =Intent(Intent.ACTION_VIEW)
            c.setData(Uri.parse(url))
            startActivity(c)
        }

    }
}