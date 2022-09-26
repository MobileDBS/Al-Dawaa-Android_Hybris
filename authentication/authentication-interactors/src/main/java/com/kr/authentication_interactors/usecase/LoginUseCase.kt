package com.kr.authentication_interactors.usecase

import com.kr.authentication_datasource.network.AuthenticationRepoImp
import com.kr.authentication_datasource.network.dto.LoginRequest
import com.kr.authentication_datasource.network.dto.LoginResponse
import jdk.internal.loader.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private  val repository: AuthenticationRepoImp
) {
/*    operator fun invoke(loginRequest: LoginRequest): Flow<Resource<>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.loginRequest()
            emit(Resource.Success(coin))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }*/
}