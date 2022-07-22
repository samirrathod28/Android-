package com.example.retrofitcrudex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Apiclient {

    //Retrofit Configuration

    lateinit var retrofit: Retrofit
    var url="https://vyasprakruti.000webhostapp.com/30Nov/"

    fun getapiclient():Retrofit
    {
        retrofit=Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}