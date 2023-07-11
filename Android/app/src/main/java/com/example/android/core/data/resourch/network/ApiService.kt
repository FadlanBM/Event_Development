package com.example.android.core.data.resourch.network

import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.core.data.resourch.response.LoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService{
    @POST("login")
    suspend fun login(
        @Body login:LoginRequest
    ):Response<LoginResponse>

    @POST("register")
    suspend fun register(
        @Body data:RegisterRequest
    ):Response<LoginResponse>
    @PUT("update_user/{id}")
    suspend fun updateUser(
        @Path("id") int: Int,
        @Body data:UpdateProfileRequest
    ):Response<LoginResponse>
    @Multipart
    @POST("upload_user/{id}")
    suspend fun uploadUser(
        @Path("id") int: Int?=null,
        @Part data:MultipartBody.Part?=null
    ):Response<LoginResponse>
}