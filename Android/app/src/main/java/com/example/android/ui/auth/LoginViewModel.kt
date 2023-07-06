package com.example.android.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.android.core.data.repository.AppRepository
import com.example.android.core.data.resourch.request.LoginRequest

class LoginViewModel(val repo:AppRepository):ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Event Fragment"
    }
    val text: LiveData<String> = _text

    fun login(data: LoginRequest)=repo.login(data).asLiveData()
}