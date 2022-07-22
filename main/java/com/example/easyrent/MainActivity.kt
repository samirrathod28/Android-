package com.example.easyrent

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    lateinit var toolbar: Toolbar
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar= findViewById(R.id.tool_login)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.view_pager)
        setviewpager()

        tabLayout =findViewById(R.id.tab1)
        tabLayout.setupWithViewPager(viewPager)

    }

    private fun setviewpager() {

        var myAdapter = MyAdapter(applicationContext,supportFragmentManager)
        myAdapter.adddata("LOG IN",LoginFragment())
        myAdapter.adddata("REGISTER",RegisterFragment())
        viewPager.adapter=myAdapter

    }
    override fun onBackPressed() {

        var alert= AlertDialog.Builder(this)
        alert.setTitle("Want To Exit??")
        alert.setPositiveButton("YES",{
                dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alert.setNegativeButton("No",{
                dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()

        })
        alert.show()

    }
}