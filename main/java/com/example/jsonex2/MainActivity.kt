package com.example.jsonex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    lateinit var list: MutableList<Model>
    lateinit var listView: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        var stringRequest = StringRequest(Request.Method.POST,"https://simplifiedcoding.net/demos/marvel/",{
            response ->

            var jsonArray= JSONArray(response)
            for(i in 0 until jsonArray.length())
            {
                var jsonObject=jsonArray.getJSONObject(i)
                var name = jsonObject.getString("name")
                var realname = jsonObject.getString("realname")
                var team = jsonObject.getString("team")
                var firstapp = jsonObject.getString("firstappearance")
                var createdby = jsonObject.getString("createdby")
                var publisher = jsonObject.getString("publisher")
                var imgurl = jsonObject.getString("imageurl")
                var bio = jsonObject.getString("bio")


                var m=Model()
                m.name = name
                m.realname = realname
                m.cby = createdby
                m.firstapp = firstapp
                m.team = team
                m.publisher = publisher
                m.imgurl = imgurl
                m.bio = bio
                list.add(m)


            var myAdapter=MyAdapter(applicationContext,list)
            listView.adapter=myAdapter
            }

            var myAdapter = MyAdapter(applicationContext,list)
            listView.adapter = myAdapter
        }
        )
        {

            Toast.makeText(applicationContext,"Turn On Internet",Toast.LENGTH_LONG).show()
        }

        var request = Volley.newRequestQueue(this)
        request.add(stringRequest)
    }
}