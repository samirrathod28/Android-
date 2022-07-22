package com.example.mysqlinsertusingrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)
        edt3=findViewById(R.id.edt3)
        btn1=findViewById(R.id.btninsert)

        btn1.setOnClickListener()
        {
            var n=edt1.text.toString()
            var p=edt2.text.toString()
            var d=edt3.text.toString()

            var stringRequest: StringRequest =object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobileproductinsert.php",
                Response.Listener {

                Toast.makeText(applicationContext,"Product Inserted", Toast.LENGTH_LONG).show()

                var i = Intent(this,MainActivity2::class.java)
                startActivity(i)


            },
                {

                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()

                }

            )

            {
                override fun getParams(): MutableMap<String, String>
                {
                    var hashMap=HashMap<String,String>()
                    hashMap.put("p_name",n)
                    hashMap.put("p_price",p)
                    hashMap.put("p_des",d)

                    return hashMap
                }
            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)

        }



    }
}