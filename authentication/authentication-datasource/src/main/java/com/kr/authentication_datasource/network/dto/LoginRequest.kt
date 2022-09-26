package com.kr.authentication_datasource.network.dto

import com.squareup.moshi.Json

data class LoginRequest(@Json(name = "identity")
                            val identity: String,
                            @Json(name = "password")
                            val password: String,
                            @Json(name = "guest_cart")
                            val guestCartId: String="")
