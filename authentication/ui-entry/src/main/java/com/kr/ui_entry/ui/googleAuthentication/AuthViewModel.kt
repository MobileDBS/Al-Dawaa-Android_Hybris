package com.kr.ui_entry.ui.googleAuthentication

import androidx.lifecycle.ViewModel
import com.kr.authentication_domain.model.GoogleUser
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {
    private val _user: MutableStateFlow<GoogleUser?> = MutableStateFlow(null)
    val user: StateFlow<GoogleUser?> = _user

    suspend fun signIn(email: String, displayName: String) {
        delay(0) // Simulating network call
        _user.value = GoogleUser(email, displayName)
    }
}