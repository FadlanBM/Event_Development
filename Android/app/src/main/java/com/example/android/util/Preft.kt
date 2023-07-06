package com.example.android.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.chibatching.kotpref.KotprefModel

object Preft:KotprefModel() {
    var isLogin by booleanPref(false)
}