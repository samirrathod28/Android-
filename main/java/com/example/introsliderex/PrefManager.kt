package com.example.introsliderex

import android.content.Context
import android.content.SharedPreferences


class PrefManager(context: Context)
{
    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var _context: Context

    // shared pref mode
    var PRIVATE_MODE = 0
    var isFirstTimeLaunch: Boolean
        get() = pref.getBoolean(IS_FIRST_TIME_LAUNCH, true)
        set(isFirstTime)
        {
            editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
            editor.commit()
        }

    companion object
    {
        // Shared preferences file name
        private const val PREF_NAME = "welcome"
        private const val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"
    }

    init
    {
        _context = context
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
}