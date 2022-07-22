package com.example.advertisement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity() {
    lateinit var adview: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adview=findViewById(R.id.adView)

        var adRequest: AdRequest =AdRequest.Builder().build()
        adview.loadAd(adRequest)
    }
}