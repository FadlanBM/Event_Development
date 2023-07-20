package com.example.android.core.di

import com.example.android.core.data.resourch.RemoteDataSourch
import com.example.android.core.data.resourch.network.ApiConfig
import org.koin.dsl.module

val AppModule= module {
    single { ApiConfig.providerApiService }
    single { RemoteDataSourch(get()) }
}