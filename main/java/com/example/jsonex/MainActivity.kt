package com.example.jsonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView
    lateinit var list: MutableList<model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView=findViewById(R.id.list)
        list=ArrayList()

        var stringRequest=StringRequest(Request.Method.GET,"https://jsonplaceholder.typicode.com/photos",{
                response->

            var jsonArray= JSONArray(response)
            for(i in 0 until jsonArray.length())
            {
                var jsonObject=jsonArray.getJSONObject(i)

                var ptitle=jsonObject.getString("title")
                var purl=jsonObject.getString("url")

                var m=model()
                m.title=ptitle
                m.url=purl
                list.add(m)

            }
            var myAdapter=MyAdapter(applicationContext,list)
            listView.adapter=myAdapter

        }
        )
        {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }

        var request=Volley.newRequestQueue(this)
        request.add(stringRequest)

    }
}