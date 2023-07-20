package com.example.android.ui.auth


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.android.core.data.repository.AppRepository
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import okhttp3.MultipartBody

class ProfileViewModel(private val repo:AppRepository):ViewModel() {
    fun updateUser(data: UpdateProfileRequest)=repo.updateUser(data).asLiveData()
    fun uploadUser(id:Int?=null, fileImage: MultipartBody.Part?=null)=repo.uploadUser(id,fileImage).asLiveData()

}