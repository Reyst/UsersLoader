package com.example.currency.myapplication.ui

import com.example.currency.myapplication.domain.User

data class MainState(
    val users: List<User> = emptyList(),
    val error: Throwable? = null,
)