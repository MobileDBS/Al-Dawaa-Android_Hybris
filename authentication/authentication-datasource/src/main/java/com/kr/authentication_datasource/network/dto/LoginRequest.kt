package com.kr.authentication_datasource.network.dto

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "client_id")
    val client_id: String ="occ_mobile",
    @Json(name = "client_secret")
    val client_secret: String ="Aldawaa@123",
    @Json(name = "grant_type")
    val grant_type: String = "password",
    @Json(name = "username")
    val username: String = "eslam@ali.com",
    @Json(name = "password")
    val password: String = "Eslam@123"
)
