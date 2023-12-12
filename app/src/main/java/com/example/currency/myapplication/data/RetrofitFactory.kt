package com.example.currency.myapplication.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        fun createRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://655395fc5449cfda0f2eedbd.mockapi.io/api/")
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}