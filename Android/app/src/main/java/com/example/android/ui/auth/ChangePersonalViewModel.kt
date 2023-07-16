package com.example.android.ui.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.android.core.data.repository.AppRepository
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import okhttp3.MultipartBody

class ChangePersonalViewModel(private val repo:AppRepository):ViewModel() {
    fun postPersonal(data: PersonalRequest)=repo.postPersonal(data).asLiveData()
}