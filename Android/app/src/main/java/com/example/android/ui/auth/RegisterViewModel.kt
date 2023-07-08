package com.example.android.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.android.core.data.repository.AppRepository
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.RegisterRequest

class RegisterViewModel(val repo:AppRepository):ViewModel() {
    fun register(data: RegisterRequest)=repo.register(data).asLiveData()
}