package com.example.composecustomnavigation.di

import com.example.composecustomnavigation.features.DetailViewModel
import com.example.composecustomnavigation.features.HomeViewModel
import com.example.composecustomnavigation.features.LoginViewModel
import com.example.composecustomnavigation.navigation.DefaultNavigator
import com.example.composecustomnavigation.navigation.Destination
import com.example.composecustomnavigation.navigation.Navigator
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<Navigator> {
        DefaultNavigator(startDestination = Destination.AuthGraph)
    }
    viewModelOf(::LoginViewModel)
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
}