package com.example.android.core.data.resourch.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {
    private const val BASE_URL="http://127.0.0.1:8000/api/"
    private val client:Retrofit
        get() {
            val gson=GsonBuilder()
                .setLenient()
                .create()
            val timeout=40L

            val interceptor=HttpLoggingInterceptor()
            interceptor.level=HttpLoggingInterceptor.Level.BODY
            val client:OkHttpClient=OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
    val providerApiService:ApiService
        get() = client.create(ApiService::class.java)
}