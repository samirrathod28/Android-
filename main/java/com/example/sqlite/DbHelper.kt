package com.example.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context): SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION){
    companion object
    {
        private var DB_NAME: String = "User.db"
        private var TABLE_NAME: String = "info"
        private var ID: String = "id"
        private var NAME: String = "name"
        private var NUMBER: String = "number"
        private var DB_VERSION: Int = 1

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val create = ("CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"
                + NUMBER + " TEXT" + ")")

        p0!!.execSQL(create)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

        var upquery="drop table if exists "+ TABLE_NAME
        p0!!.execSQL(upquery)
    }

    fun savedata(m:Model):Long
    {
        var id:Long=0

        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME,m.name)
        contentValues.put(NUMBER,m.number)
        id=db.insert(TABLE_NAME,ID,contentValues)
        return id
    }
}