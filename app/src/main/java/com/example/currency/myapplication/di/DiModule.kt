package com.example.currency.myapplication.di

import com.example.currency.myapplication.data.DefaultUserRepository
import com.example.currency.myapplication.data.RemoteUserDataSource
import com.example.currency.myapplication.data.RetrofitFactory
import com.example.currency.myapplication.data.RetrofitUserDataSource
import com.example.currency.myapplication.data.UserApi
import com.example.currency.myapplication.domain.UserLoader
import com.example.currency.myapplication.domain.UserRepository
import com.example.currency.myapplication.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val diModule = module {

    single<Retrofit> { RetrofitFactory.createRetrofit() }

    factory { get<Retrofit>().create(UserApi::class.java) }

    factory<RemoteUserDataSource> { RetrofitUserDataSource(get()) }
    single<UserRepository> { DefaultUserRepository(get()) }

    factory { UserLoader(get()) }

    viewModel { MainViewModel(get()) }

}