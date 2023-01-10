package com.kr.authentication_datasource.network.dto

import com.kr.authentication_domain.model.User
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginResponse(

    @Json(name = "access_token")
    val access_token: String?,
    @Json(name = "token_type")
    val token_type: String?=" ",
    @Json(name = "refresh_token")
    val refresh_token: String?,
    @Json(name = "expires_in")
    val expires_in: Long?,
    @Json(name = "scope")
    val scope: String?,

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