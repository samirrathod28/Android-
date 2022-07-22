package com.example.diliciouspizza

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menuactivity.*

class menuactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menuactivity)

        bill.setOnClickListener {
            var amount=0
            val builder:StringBuilder= StringBuilder("\n Selected Items \n")

            if(chk1.isChecked)
            {
                amount+=199
                builder.append(" \n Margarita @rs.199 \n")
            }
            if(chk2.isChecked)
            {
                amount+=249
                builder.append("\n Italian @rs.249 \n")
            }
            if(chk3.isChecked)
            {
                amount+=299
                builder.append("\n Sweet Corn @rs.299 \n")
            }
            if(chk4.isChecked)
            {
                amount+=149
                builder.append("\n Garlic Bread @rs.149 \n")
            }
            builder.append(" \n Total :$amount")

            val i = Intent(this,display_bill::class.java)
            i.putExtra("bill",builder.toString())
            startActivity(i)

        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.my_menu,menu)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {

            R.id.call_txt->
            {

                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:"+"7984666909")
                startActivity(dialIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}