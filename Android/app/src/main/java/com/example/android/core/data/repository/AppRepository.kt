package com.example.android.core.data.repository

import android.util.Log
import com.example.android.core.data.resourch.RemoteDataSourch
import com.example.android.core.data.resourch.network.Resourch
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AppRepository (val remote:RemoteDataSourch) {
    fun login(data: LoginRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.login(data).let {
                if (it.isSuccessful){
                    Preft.isLogin=true
                    val body=it.body()
                    val user=body?.data
                    Preft.setUser(user)
                    emit(Resourch.success(user))
                    Log.d("TAG","Berhasil Login")
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"Email/Password Salah",null))
                    Log.d("TAG","ERROR")
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
            Log.d("TAG","ERROR ="+e.message)
        }
    }
    fun register(data: RegisterRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.register(data).let {
                if (it.isSuccessful){
                    Preft.isLogin=true
                    val body=it.body()
                    val user=body?.data
                    Preft.setUser(user)
                    emit(Resourch.success(user))
                    Log.d("TAG","Berhasil Login")
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The email has already been taken ",null))
                    Log.d("TAG","ERROR")
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
            Log.d("TAG","ERROR ="+e.message)
        }
    }
    fun updateUser(data: UpdateProfileRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.updateUser(data).let {
                if (it.isSuccessful){
                    val body=it.body()
                    val user=body?.data
                    Preft.setUser(user)
                    emit(Resourch.success(user))
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The update account error ",null))
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
        }
    }
}