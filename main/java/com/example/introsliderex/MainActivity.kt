package com.example.introsliderex



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val prefManager = PrefManager(applicationContext)
        if (prefManager.isFirstTimeLaunch) {
            prefManager.isFirstTimeLaunch = false
            startActivity(Intent(this@MainActivity, WelcomeActivity::class.java))
            finish()
        }
    }

    protected fun btn_Click(view: View?) {
        Toast.makeText(this@MainActivity, "clicked on button", Toast.LENGTH_LONG).show()
    }
}