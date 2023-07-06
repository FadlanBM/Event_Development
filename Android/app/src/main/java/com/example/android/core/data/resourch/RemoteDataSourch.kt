package com.example.android.core.data.resourch

import com.example.android.core.data.resourch.network.ApiService
import com.example.android.core.data.resourch.request.LoginRequest

class RemoteDataSourch(val api:ApiService) {
    suspend fun login(data:LoginRequest)=api.login(data)
}