package com.example.jsonex2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context,var list: MutableList<Model>):BaseAdapter() {
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

        var layout : LayoutInflater = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,p2,false)

        var name = view.findViewById<TextView>(R.id.idName)
        var realname =view.findViewById<TextView>(R.id.idName)
        var team = view.findViewById<TextView>(R.id.idTeam)
        var firstapp = view.findViewById<TextView>(R.id.idFA)
        var createdby = view.findViewById<TextView>(R.id.idCB)
        var publisher =view.findViewById<TextView>(R.id.idPub)
        var imgurl =view.findViewById<ImageView>(R.id.image)
        var bio =view.findViewById<TextView>(R.id.idBio)

        name.setText(list.get(p0).name)
        realname.setText(list.get(p0).realname)
        team.setText(list.get(p0).team)
        firstapp.setText(list.get(p0).firstapp)
        createdby.setText(list.get(p0).cby)
        publisher.setText(list.get(p0).publisher)
        bio.setText(list.get(p0).bio)
        Picasso.get()
            .load(list.get(p0).imgurl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(imgurl)

        return view
    }
}