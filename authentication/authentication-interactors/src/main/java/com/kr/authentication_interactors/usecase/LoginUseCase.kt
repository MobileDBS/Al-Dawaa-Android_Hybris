package com.kr.authentication_interactors.usecase

import com.kr.authentication_datasource.network.AuthenticationRepoImp
import com.kr.authentication_datasource.network.dto.LoginRequest
import com.kr.authentication_datasource.network.dto.toUser
import com.kr.authentication_domain.model.User
import com.kr.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private  val repository: AuthenticationRepoImp
) {
   operator fun invoke(identity :String , password :String): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.loginRequest(identity , password).toUser()
            emit(Resource.Success(response))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection."))
        }
    }
}