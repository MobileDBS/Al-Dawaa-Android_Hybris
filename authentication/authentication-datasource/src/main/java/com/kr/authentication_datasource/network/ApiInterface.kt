package com.kr.authentication_datasource.network

import com.kr.authentication_datasource.network.dto.LoginRequest
import com.kr.authentication_datasource.network.dto.LoginResponse
import retrofit2.http.*

interface ApiInterface {
    //Login
    @POST("authorizationserver/oauth/token")
  suspend fun login(
        @Query("client_id") client_id:String="occ_mobile",
        @Query("client_secret") client_secret:String="Aldawaa@123",
        @Query("grant_type") grant_type:String="password",
        @Query("username") username:String ="eslam@ali.com" ,
        @Query("password") password:String ="Eslam@123"
    ): LoginResponse



}