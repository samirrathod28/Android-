package com.example.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var btn1: Button
    lateinit var btn2:Button
    lateinit var dbHelper: DbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1=findViewById(R.id.edtname)
        edt2=findViewById(R.id.edtnum)
        btn1=findViewById(R.id.btninsert)
        btn2=findViewById(R.id.btnview)
        dbHelper= DbHelper(applicationContext)

        btn1.setOnClickListener()
        {

            var name1=edt1.text.toString()
            var num1=edt2.text.toString()

            var m=Model()
            m.name=name1
            m.number=num1

            var id:Long= dbHelper.savedata(m)

            Toast.makeText(applicationContext,"Record insrted"+id,Toast.LENGTH_LONG).show()


        }
    }
}