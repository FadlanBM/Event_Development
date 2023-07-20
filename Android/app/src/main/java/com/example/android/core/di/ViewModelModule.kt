package com.example.android.core.di

import com.example.android.ui.auth.ChangePersonalViewModel
import com.example.android.ui.auth.LoginViewModel
import com.example.android.ui.auth.ProfileViewModel
import com.example.android.ui.auth.RegisterViewModel
import com.example.android.ui.management_event.Management_ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ViewModelModule= module {
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { Management_ViewModel(get()) }
    viewModel { ChangePersonalViewModel(get()) }
}