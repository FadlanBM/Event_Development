package com.example.android.ui.management_event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.android.core.data.repository.AppRepository
import com.example.android.core.data.resourch.request.EventsRequest

class Management_ViewModel(private val repo:AppRepository):ViewModel() {

    fun events(data: EventsRequest)=repo.events(data).asLiveData()
}