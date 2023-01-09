package com.kr.ui_login.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kr.authentication_interactors.usecase.LoginUseCase
import com.kr.core.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userCase: LoginUseCase
    )
    : ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state
    init {
        login()
    }

    private fun login() {
       userCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(user = result.data)
                       Log.v("loginResponse" , result.data?.firstname.toString())
                }
                is Resource.Error -> {
                    _state.value = LoginState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}