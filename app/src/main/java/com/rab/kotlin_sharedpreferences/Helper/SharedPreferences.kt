package com.rab.kotlin_sharedpreferences.Helper

import android.content.Context
import android.content.SharedPreferences

/***
 * @author rabkawork
 * @createdAt November 2020
 */
class SharedPreferences(val context: Context) {
    private val PREFS_NAME = "rab_session_preferences"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
}