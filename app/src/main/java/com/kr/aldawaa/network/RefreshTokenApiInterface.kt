package com.kr.aldawaa.network

import retrofit2.Call
import retrofit2.http.*

interface RefreshTokenApiInterface {
    @POST("authorizationserver/oauth/token?")
    fun getAccessToken(@Query("client_id") client_id:String="occ_mobile",
                       @Query("client_secret") client_secret:String="Aldawaa@123",
                       @Query("grant_type") grant_type:String="refresh_token",
                       @Query("refresh_token") refresh_token:String)
    : Call<String>

}