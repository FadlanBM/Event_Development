package com.example.android.core.di

import com.example.android.ui.auth.LoginViewModel
import com.example.android.ui.auth.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
}