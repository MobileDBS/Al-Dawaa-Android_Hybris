package com.kr.authentication_datasource.network

import com.kr.authentication_datasource.network.dto.LoginResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthenticationRepoImp  {

/*    suspend fun getLoginDataa(
        apiInterface: ApiInterface,
    ):
            LoginResponse {
        return apiInterface.getDirections(
                "driving",
                "less_driving",
                "AIzaSyCh3G_4p1rllyDCdJ53HoxdYa5x_q_Gytw",
                startFromDb,
                endFromServer
            )

    }*/

/*    suspend fun getLoginData(
        startFromDb: String,
        endFromServer: String
    ): Flow<LoginResponse> {
        return flow {
            val result = apiServicesGoogleDirections.getDirections(
                "driving",
                "less_driving",
                "AIzaSyCh3G_4p1rllyDCdJ53HoxdYa5x_q_Gytw",
                startFromDb,
                endFromServer
            ).await()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }*/
}
/*
@Inject constructor(
    private  val api: CoinPaprikaApi
)
{

    override suspend fun getCoins(): List<CoinDto> {
        return  api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return  api.getCoinById(coinId)
    }
}*/
