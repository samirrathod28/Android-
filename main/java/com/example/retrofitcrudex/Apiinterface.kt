package com.example.retrofitcrudex


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface {

    //-----------------------INSERT START------------------------//
    @FormUrlEncoded
    @POST("mobileproductinsert.php")
    fun insertdata
                (
        @Field("p_name") product_name:String,
        @Field("p_price") product_price:String,
        @Field("p_des") product_description:String
    ): Call<Model?>?
    //-----------------------INSERT END------------------------//

    //-----------------------VIEW START------------------------//
    @get:GET("mobileview.php")
    val viewdata :Call<List<Model?>?>?
    //-----------------------VIEW END------------------------//
}