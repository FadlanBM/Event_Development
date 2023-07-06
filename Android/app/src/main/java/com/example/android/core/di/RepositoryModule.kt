package com.example.android.core.di

import com.example.android.core.data.repository.AppRepository
import org.koin.dsl.module

val repositoryModule= module {
    single { AppRepository(get()) }
}