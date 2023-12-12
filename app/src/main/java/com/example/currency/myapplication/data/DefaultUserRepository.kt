package com.example.currency.myapplication.data

import com.example.currency.myapplication.domain.User
import com.example.currency.myapplication.domain.UserRepository

class DefaultUserRepository(
    private val ds: RemoteUserDataSource
): UserRepository {
    override suspend fun getUsers(): Result<List<User>>  = runCatching {
        ds.getUsers().toDomain()
    }
}

