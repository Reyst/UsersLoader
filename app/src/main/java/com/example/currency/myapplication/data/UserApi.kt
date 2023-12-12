package com.example.currency.myapplication.data

import retrofit2.http.GET

interface UserApi {

    @GET("v2/content/users")
    suspend fun getUsers(): List<UserDto>

}