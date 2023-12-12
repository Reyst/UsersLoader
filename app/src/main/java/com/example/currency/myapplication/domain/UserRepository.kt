package com.example.currency.myapplication.domain

interface UserRepository {

    suspend fun getUsers(): Result<List<User>>

}