package com.example.retrofitcrudex

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: List<Model>)  : RecyclerView.Adapter<MyAdapter.MyView>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyView {
        val l1: LayoutInflater = LayoutInflater.from(context)
        var view=l1.inflate(R.layout.design,parent,false)

        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyView, position: Int) {
        holder.txt1.setText(list.get(position).product_name)
        holder.txt2.setText(list.get(position).product_price)
        holder.txt3.setText(list.get(position).product_des)


        var alertDialog = AlertDialog.Builder(holder.txt1.context)
        alertDialog.setTitle("Select Operations ??")
        alertDialog.setPositiveButton("Update",{
                dialogInterface: DialogInterface, i: Int ->


        })
        alertDialog.setNegativeButton("Delete",{
                dialogInterface: DialogInterface, i: Int ->


        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class MyView(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        var txt1: TextView =itemView.findViewById(R.id.txtname)
        var txt2:TextView=itemView.findViewById(R.id.txtprice)
        var txt3:TextView=itemView.findViewById(R.id.txtdes)


    }
}