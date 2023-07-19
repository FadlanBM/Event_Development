package com.example.android.core.data.resourch.network

import com.example.android.core.data.resourch.request.EventsRequest
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.core.data.resourch.request.getPassRequest
import com.example.android.core.data.resourch.response.LoginResponse
import com.example.android.core.data.resourch.response.BaseResponse
import com.example.android.core.data.resourch.response.PersonalResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
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

    @POST("person")
    suspend fun postPersonal(
        @Body data:PersonalRequest
    ):Response<BaseResponse<PersonalResponse>>

    @POST("add_event")
    suspend fun events(
        @Body event:EventsRequest
    ):Response<LoginResponse>

    @POST("delete_account/{id}")
    suspend fun deleteAccount(
        @Path("id")Int:Int?=null,
    ):Response<LoginResponse>
    @POST("getPass/{id}")
    suspend fun getPass(
        @Path("id")Int:Int?=null,
        @Body data:getPassRequest
    ):Response<LoginResponse>

    @GET("person/{id}")
    suspend fun getPerson(
        @Path("id")Int:Int?=null,
    ):Response<BaseResponse<PersonalResponse>>

}