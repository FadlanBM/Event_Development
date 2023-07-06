package com.example.android.core.data.resourch.response

import com.example.android.core.data.resourch.model.User

data class LoginResponse(
    val code:Int?=null,
    val message:String?=null,
    val data:User?=null
)

