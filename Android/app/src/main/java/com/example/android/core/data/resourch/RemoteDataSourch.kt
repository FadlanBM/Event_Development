package com.example.android.core.data.resourch

import com.example.android.core.data.resourch.network.ApiService
import com.example.android.core.data.resourch.request.EventsRequest
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.core.data.resourch.request.getPassRequest
import okhttp3.MultipartBody

class RemoteDataSourch(private val api:ApiService) {
    suspend fun login(data:LoginRequest)=api.login(data)
    suspend fun register(data:RegisterRequest)=api.register(data)
    suspend fun updateUser(data:UpdateProfileRequest)=api.updateUser(data.id, data)
    suspend fun uploadUser(id:Int?=null, fileImage:MultipartBody.Part?=null)=api.uploadUser(id,fileImage)

    suspend fun events(data: EventsRequest)=api.events(data)
    suspend fun postPersonal(data: PersonalRequest)=api.postPersonal(data)
    suspend fun getPersonal(id: Int?)=api.getPerson(id)
    suspend fun delete_account(id: Int?)=api.deleteAccount(id)
    suspend fun getPass(id: Int?,data: getPassRequest)=api.getPass(id,data)
}