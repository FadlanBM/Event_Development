package com.example.android.util

import android.app.Activity
import android.app.Person
import android.content.Context
import android.content.SharedPreferences
import com.chibatching.kotpref.KotprefModel
import com.example.android.core.data.resourch.model.User
import com.example.android.core.data.resourch.response.PersonalResponse
import com.inyongtisto.myhelper.extension.toJson
import com.inyongtisto.myhelper.extension.toModel

object Preft:KotprefModel() {
    var isLogin by booleanPref(false)
    var user by stringPref()
    var person by stringPref()

    fun setUser(data: User?){
        user= data.toJson()
    }  fun setPerson(data: PersonalResponse?){
        person= data.toJson()
    }

    fun getUser():User?{
        if (user.isEmpty()) return null
        return user.toModel(User::class.java)
    }
    fun getPerson():PersonalResponse?{
        if (person.isEmpty()) return null
        return person.toModel(PersonalResponse::class.java)
    }
}