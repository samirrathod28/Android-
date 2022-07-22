package com.example.jsonex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context,var list: MutableList<model>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var layout: LayoutInflater = LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,p2,false)

        var txt2:TextView=view.findViewById(R.id.txt2)
        var image: ImageView =view.findViewById(R.id.img)

        txt2.setText(list.get(p0).title)
        Picasso.get()
            .load(list.get(p0).url)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(image)

        return view

    }
}