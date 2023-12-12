package com.example.currency.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currency.myapplication.domain.UserLoader
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val loader: UserLoader,
): ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    fun loadUsers() {
        viewModelScope.launch {
            loader.getUsers()
                .catch { error -> _state.update { it.copy(error = error) } }
                .collect { users -> _state.update { it.copy(users = users) } }
        }
    }

    fun resetError() = _state.update { it.copy(error = null) }
}