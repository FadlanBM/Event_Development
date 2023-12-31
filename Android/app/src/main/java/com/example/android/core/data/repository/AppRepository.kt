package com.example.android.core.data.repository

import android.util.Log
import com.example.android.core.data.resourch.RemoteDataSourch
import com.example.android.core.data.resourch.network.Resourch
import com.example.android.core.data.resourch.request.EventsRequest
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.core.data.resourch.request.PersonalRequest
import com.example.android.core.data.resourch.request.RegisterRequest
import com.example.android.core.data.resourch.request.UpdateProfileRequest
import com.example.android.core.data.resourch.request.getPassRequest
import com.example.android.util.Preft
import com.inyongtisto.myhelper.extension.getErrorBody
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import java.lang.Exception

class AppRepository (private val remote:RemoteDataSourch) {
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
    fun postPersonal(data: PersonalRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.postPersonal(data).let {
                if (it.isSuccessful){
                    val body=it.body()
                    val person=body?.data
                    Preft.setPerson(person)
                    emit(Resourch.success(person))
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The update account error ",null))
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
        }
    }
    fun uploadUser(id:Int?=null, fileImage: MultipartBody.Part?=null) = flow {
        emit(Resourch.loading(null))
        try {
            remote.uploadUser(id,fileImage).let {
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
    fun getPersonal(id:Int?=null) = flow {
        emit(Resourch.loading(null))
        try {
            remote.getPersonal(id).let {
                if (it.isSuccessful){
                    val body=it.body()
                    val person=body?.data
                    Preft.setPerson(person)
                    emit(Resourch.success(person))
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The update account error ",null))
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
        }
    }

    fun delete_account(id:Int?=null) = flow {
        emit(Resourch.loading(null))
        try {
            remote.delete_account(id).let {
                if (it.isSuccessful){
                    val body=it.body()
                    val person=body?.data
                    emit(Resourch.success(person))
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The update account error ",null))
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
        }
    }
    fun getPass(id:Int?=null,data:getPassRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.getPass(id,data).let {
                if (it.isSuccessful){
                    val body=it.body()
                    val person=body?.data
                    emit(Resourch.success(person))
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The update account error ",null))
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
        }
    }

    fun events(data: EventsRequest) = flow {
        emit(Resourch.loading(null))
        try {
            remote.events(data).let {
                if (it.isSuccessful){
                    emit(Resourch.success(data.name))
                }else{
                    emit(Resourch.error(it.getErrorBody()?.message?:"The update account error ",null))
                }
            }
        }catch (e:Exception){
            emit(Resourch.error(e.message?:"terjadi Kesalahan",null))
        }
    }
}