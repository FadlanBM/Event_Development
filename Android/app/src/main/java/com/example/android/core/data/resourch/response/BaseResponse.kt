package com.example.android.core.data.resourch.response

data class BaseResponse<T>(
    val code:Int?=null,
    val message:String?=null,
    val data:T?=null
)

