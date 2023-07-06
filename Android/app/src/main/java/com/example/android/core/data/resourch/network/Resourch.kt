package com.example.android.core.data.resourch.network

data class Resourch<out T>(val state: State,val body:T?,val message:String?){
    companion object{
        fun <T> success(data:T?):Resourch<T>{
            return Resourch(State.SUCCESS,data,null)
        }
        fun <T> error(msg:String, data:T?):Resourch<T>{
            return Resourch(State.ERROR,data,msg)
        }
        fun <T> loading(data:T?):Resourch<T>{
            return Resourch(State.LOADING,data,null)
        }
    }
}