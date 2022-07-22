package com.example.frgmt

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class fragment1 : Fragment() {

    lateinit var txt:TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_fragment1, container, false)

        txt=view.findViewById(R.id.txtfrm)

        txt.setOnClickListener(){

          ///  var i = Intent(activity,MainActivity2::class.java)
          //  startActivity(i)
            var b= Fragment2()
            var fm:FragmentManager= childFragmentManager
            var ft:FragmentTransaction=fm.beginTransaction()
            ft.replace(R.id.frm2,b).commit()


        }

        return view
    }

}