package com.example.android.core.data.repository

import android.util.Log
import com.example.android.core.data.resourch.RemoteDataSourch
import com.example.android.core.data.resourch.request.LoginRequest
import com.example.android.util.Preft
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AppRepository (val remote:RemoteDataSourch) {
    fun login(data: LoginRequest) = flow {
        try {
            remote.login(data).let {
                if (it.isSuccessful){
                    val body=it.body()
                    emit(body)
                    Log.d("TAG","Berhasil Login"+body.toString())
                }else{
                    Log.d("TAG","ERROR")
                }
            }
        }catch (e:Exception){
            Log.d("TAG","ERROR ="+e.message)
        }
    }
}