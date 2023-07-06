package com.example.android.core.data.resourch.network

import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.response.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService{
    @POST("login")
    suspend fun login(
        @Body login:LoginRequest
    ):Response<LoginResponse>
}