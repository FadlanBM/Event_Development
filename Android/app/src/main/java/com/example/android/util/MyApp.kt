package com.example.android.util

import android.app.Application
import com.example.android.core.di.AppModule
import com.example.android.core.di.ViewModelModule
import com.example.android.core.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
            startKoin {
                androidContext(this@MyApp)
                modules(listOf(AppModule, repositoryModule, ViewModelModule))
            }
    }
}