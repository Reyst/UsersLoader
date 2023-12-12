package com.example.currency.myapplication.domain

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class UserLoader(
    private val repository: UserRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    fun getUsers(): Flow<List<User>> {
        return flow {
            repository.getUsers()
                .fold(
                    onSuccess = { emit(it) },
                    onFailure = { throw it }
                )
        }.flowOn(dispatcher)
    }
}