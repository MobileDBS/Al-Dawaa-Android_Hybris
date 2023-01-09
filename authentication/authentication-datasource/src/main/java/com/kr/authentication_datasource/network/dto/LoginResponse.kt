package com.kr.authentication_datasource.network.dto

import com.kr.authentication_domain.model.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(
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

fun LoginResponse.toUser(): User {
    return User(
//        id = this.userDto?.id,
//        email = this.userDto?.email,
//        firstname = this.userDto?.firstname,
//        lastname = this.userDto?.lastname,
//        gender = this.userDto?.gender,
//        phone = this.mobileNumber

    )}