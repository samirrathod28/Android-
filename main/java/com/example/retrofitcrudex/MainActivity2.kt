package com.example.retrofitcrudex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {

    lateinit var list: List<Model>
    lateinit var api:Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        list=ArrayList()

        val rl: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rview1.layoutManager=rl

        api=Apiclient().getapiclient().create(Apiinterface::class.java)
        val call=api.viewdata

        call!!.enqueue(object: Call<List<Model?>>, Callback<List<Model?>?>{
            override fun clone(): Call<List<Model?>> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<Model?>> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<List<Model?>>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<Model?>?>, response: Response<List<Model?>?>) {
                list= response.body() as List<Model>
                var adapter=MyAdapter(applicationContext,list)
                rview1.adapter=adapter
            }

            override fun onFailure(call: Call<List<Model?>?>, t: Throwable) {
                Toast.makeText(applicationContext,"",Toast.LENGTH_LONG).show()
            }

        })
    }
}