package com.example.retrofitcrudex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var api: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btninsert.setOnClickListener()
        {
            var pname = edtname.text.toString()
            var pprice = edtprice.text.toString()
            var pdes = edtdes.text.toString()

            api = Apiclient().getapiclient().create(Apiinterface::class.java)//combine

            val call: Call<Model?>? = api.insertdata(pname, pprice, pdes)
            call!!.enqueue(object : Callback<Model?> {
                override fun onResponse(call: Call<Model?>, response: Response<Model?>)
                {
                    Toast.makeText(applicationContext, "Product Inserted", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<Model?>, t: Throwable)
                {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
                }
            })
            Toast.makeText(applicationContext, "Product Inserted", Toast.LENGTH_LONG).show()

        }

        btnView.setOnClickListener(){

            var i= Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }

    }
}