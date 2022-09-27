package com.kr.ui_login.ui

import com.kr.authentication_domain.model.User


data class LoginState(
    val isLoading: Boolean = false,
    val user :User ?= null,
    val error: String = ""
)
