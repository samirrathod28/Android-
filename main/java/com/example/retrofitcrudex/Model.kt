package com.example.retrofitcrudex

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Model {


    @Expose
    @SerializedName("p_name")
    var product_name=""

    @Expose
    @SerializedName("p_price")
    var product_price=""

    @Expose
    @SerializedName("p_des")
    var product_des=""

}