package com.example.easyrent.ui.RentHome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.easyrent.R

class RentHome : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_rent, container, false)

        val imageList = ArrayList<SlideModel>() // Create image list

// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel(R.drawable.renthome,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.houseimg,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.lowerent,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.sliderrent,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.rentslider,ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.forrent,ScaleTypes.FIT))

        val imageSlider = view.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        return view
    }

}