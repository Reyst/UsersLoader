package com.example.currency.myapplication.data

interface RemoteUserDataSource {
    suspend fun getUsers(): List<UserDto>
}

class RetrofitUserDataSource(
    private val api: UserApi,
): RemoteUserDataSource {
    override suspend fun getUsers(): List<UserDto> = api.getUsers()
}