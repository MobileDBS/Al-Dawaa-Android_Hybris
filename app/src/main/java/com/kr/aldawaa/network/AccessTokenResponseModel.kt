package com.kr.aldawaa.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AccessTokenResponseModel(
    @Json(name = "access_token")
    var accessToken: String = "",
    @Json(name = "expires_in")
    var expiresIn: Long = 0,
    @Json(name = "refresh_token")
    var refreshToken: String = "",
    @Json(name = "scope")
    var scope: String = "",
    @Json(name = "token_type")
    var tokenType: String = ""
)