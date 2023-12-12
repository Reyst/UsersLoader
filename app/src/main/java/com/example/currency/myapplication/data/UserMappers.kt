package com.example.currency.myapplication.data

import com.example.currency.myapplication.domain.User

fun UserDto.toDomain() = User(
    id = id?.toIntOrNull() ?: 0,
    name = name.orEmpty(),
    avatarUrl = avatar.orEmpty(),
    // created at
)

fun List<UserDto>.toDomain() = map { it.toDomain() }