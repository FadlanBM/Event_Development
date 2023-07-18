package com.example.android.core.data.resourch.response

import com.example.android.core.data.resourch.model.Person
import com.example.android.core.data.resourch.model.User

data class PersonalResponse(
    val address: String?,
    val birth: String?,
    val created_at: String?,
    val fullname: String?="Guest",
    val id: Int?,
    val phone: String?,
    val sex: String?,
    val updated_at: String?,
    val users_id: String?
)

