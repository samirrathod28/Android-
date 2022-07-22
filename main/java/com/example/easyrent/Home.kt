package com.example.easyrent

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.easyrent.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("session", MODE_PRIVATE)

        Toast.makeText(this,"Welcome"+" "+sharedPreferences.getString("n1","Default Name"), Toast.LENGTH_LONG).show()


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_Home, R.id.navigation_Add,R.id.navigation_PayRent,R.id.navigation_Profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.optionmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {

            R.id.m1->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
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