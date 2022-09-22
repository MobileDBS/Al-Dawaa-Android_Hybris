package com.kr.authentication_datasource.network

import com.kr.authentication_datasource.network.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    //Login
    @POST("{lang}/V1/crocoit/auth/login")
   suspend fun Login(
        @Header("firebase-token") fireBaseToken: String,
        @Path("lang") lang: String,
//        @Body userData: //TODO:Login Request
    ): LoginResponse
}