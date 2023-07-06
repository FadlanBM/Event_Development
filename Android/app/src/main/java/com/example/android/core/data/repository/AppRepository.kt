package com.example.android.core.data.repository

import android.util.Log
import com.example.android.core.data.resourch.RemoteDataSourch
import com.example.android.core.data.resourch.network.Resourch
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.util.Preft
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AppRepository (val remote:RemoteDataSourch) {
    fun login(data: LoginRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.login(data).let {
                if (it.isSuccessful){
                    val body=it.body()
                    emit(Resourch.success(body?.data))
                    Log.d("TAG","Berhasil Login")
                }else{
                    emit(Resourch.error(it.body()?.message?:"Email/Password Salah",null))
                    Log.d("TAG","ERROR")
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
            Log.d("TAG","ERROR ="+e.message)
        }
    }
}