package com.example.mysqlinsertusingrecycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(context: Context, list:List<Model>) : RecyclerView.Adapter<MyAdapter.MyView>() {

    var context: Context
    var dataList: List<Model>

    init {
        this.context = context
        this.dataList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyView {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.design, parent, false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyView, position: Int) {

        holder.txt1.setText(dataList.get(position).pname)
        holder.txt2.setText(dataList.get(position).pprice)
        holder.txt3.setText(dataList.get(position).pdes)


    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyView(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        var txt1:TextView =itemView.findViewById(R.id.txt1)
        var txt2:TextView=itemView.findViewById(R.id.txt2)
        var txt3:TextView=itemView.findViewById(R.id.txt3)



    }
}