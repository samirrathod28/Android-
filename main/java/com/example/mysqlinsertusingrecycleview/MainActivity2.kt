package com.example.mysqlinsertusingrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity2 : AppCompatActivity() {

    lateinit var recyclerView:RecyclerView
    lateinit var list:List<Model>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        recyclerView=findViewById(R.id.recycle)
         list=ArrayList<Model>()

        var layoutManager: RecyclerView.LayoutManager= LinearLayoutManager(applicationContext)
        recyclerView.layoutManager=layoutManager

        var stringRequest= StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobileview.php",{ response->

            var jsonArray= JSONArray(response)
            for(i in 0 until  jsonArray.length())
            {
                var jsonobject=jsonArray.getJSONObject(i)

                var pname=jsonobject.getString("p_name")
                var pprice=jsonobject.getString("p_price")
                var pdes=jsonobject.getString("p_des")

                var m=Model()
                m.pname=pname
                m.pprice=pprice
                m.pdes=pdes
                (list as ArrayList<Model>).add(m)
            }

            var myAdapter=MyAdapter(applicationContext,list)
            recyclerView.adapter=myAdapter

        })
        {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }
        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }
}