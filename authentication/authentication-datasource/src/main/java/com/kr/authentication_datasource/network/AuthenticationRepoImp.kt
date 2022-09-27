package com.kr.authentication_datasource.network

import com.kr.authentication_datasource.network.dto.LoginRequest
import com.kr.authentication_datasource.network.dto.LoginResponse
import com.squareup.moshi.Json
import javax.inject.Inject

class AuthenticationRepoImp @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun loginRequest(identity :String , password :String ): LoginResponse {
        val loginRequest = LoginRequest(identity , password , "");
        return apiInterface.login(
            "",
            "english",
          loginRequest
        )

    }
}


//LoginRequest("0562137538", "123456", "")