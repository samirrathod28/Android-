package com.example.sqllitedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.name)
        edt2=findViewById(R.id.email)
        edt3=findViewById(R.id.mobileno)
        btn1=findViewById(R.id.register)
        btn2= findViewById(R.id.view)

        btn1.setOnClickListener()
        {
            var name=edt1.text.toString()
            var email=edt2.text.toString()
            var mobNo=edt3.text.toString()

            var stringRequest:StringRequest=object:StringRequest(Request.Method.POST,"https://unapprised-countrie.000webhostapp.com/Demo/insert2.php",Response.Listener
            {
                Toast.makeText(applicationContext,"Registration Success",Toast.LENGTH_LONG).show()
            },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })

            {
                override fun getParams(): MutableMap<String, String>
                {
                    val map = HashMap<String, String>()
                    map["name"]=name
                    map["Mobile"]=mobNo
                    map["email"]=email

                    return map
                }

            }
            val queue = Volley.newRequestQueue(this)
            queue.add(stringRequest)




        }

        btn2.setOnClickListener(){


        }


    }
}