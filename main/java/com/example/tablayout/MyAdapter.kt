package com.example.tablayout

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyAdapter(var context: Context,var fm:FragmentManager) :FragmentStatePagerAdapter(fm)
{
    var listFragment: MutableList<Fragment> = ArrayList()
    var listtitle: MutableList<String> = ArrayList()

    override fun getCount(): Int
    {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment
    {
        return listFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return listtitle.get(position)
    }

    fun adddata(list: String,fragment: Fragment)
    {
        listtitle!!.add(list)
        listFragment!!.add(fragment)
    }


}