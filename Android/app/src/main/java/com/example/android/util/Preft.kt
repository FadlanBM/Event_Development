package com.example.android.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class Preft(activity: Activity) {
    private var sp:SharedPreferences?=null
    private val login="login"

    init {
        sp=activity.getSharedPreferences("PREFT",Context.MODE_PRIVATE)
    }

    fun setIsLogin(Value:Boolean){
        sp!!.edit().putBoolean(login,Value)
    }
    fun getIsLogin():Boolean{
       return sp!!.getBoolean(login,false)
    }

}