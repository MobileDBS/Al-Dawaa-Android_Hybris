package com.kr.aldawaa.network

import android.content.Context
import android.os.Looper
import com.kr.aldawaa.R
import com.kr.components.BuildConfig
import com.kr.core.Constants
import com.kr.core.ConvertMinutesTimeToHHMMString
import com.kr.core.Logger
import okhttp3.*
import retrofit2.Retrofit
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AuthToken @Inject constructor(context: Context,val refreshTokenApiInterface: RefreshTokenApiInterface) : Interceptor {
    var cont = context
    var refreshToken = ""
    var accessToken = ""
    var expiresFromServer:Long = 45000 // From sharedPreference
    var expireTimeStamp:Long = 0L // put it in sharedPreference

    override fun intercept(chain: Interceptor.Chain): Response {
        val sp = cont.getSharedPreferences("app_data", 0)
         expireTimeStamp = ConvertMinutesTimeToHHMMString(expiresFromServer) // put it in sharedPreference

//        if (sp!!.getLong("expires_in", 0) - sp.getLong("time_delta", 0) - System.currentTimeMillis() / 1000 <= 60 && !sp.getString("refresh_token", "")!!.isBlank()) updateAccessToken(cont)
        if (expireTimeStamp - System.currentTimeMillis()  <= 60 && !refreshToken.isBlank()) updateAccessToken(cont)

        val initialRequest = if (expireTimeStamp - System.currentTimeMillis()  <= 60 && !refreshToken.isBlank()) {
            updateAccessToken(cont)
            requestBuilder(chain)
        } else {
            requestBuilder(chain)
        }


        val initialResponse = chain.proceed(initialRequest)

        return if (initialResponse.code == 401 && !refreshToken.isNullOrBlank() && expireTimeStamp - System.currentTimeMillis() / 1000 <= 60) {
            updateAccessToken(cont)
            initialResponse.close()
            val authorizedRequest = initialRequest
                .newBuilder()
                .addHeader("Content-type:", "application/json")
                .addHeader("Authorization", "Bearer " + accessToken)
                .build()
            chain.proceed(authorizedRequest)
        } else {
            val errorBody = initialResponse.message
            when {

            }
            if (initialResponse.code == 500) {
                val thread = object : Thread() {
                    override fun run() {
                        Looper.prepare()
                        Logger("token",true).log(" errorBody: $errorBody ")
                     //   Toast.makeText(cont, cont.getString(R.string.server_error_500), Toast.LENGTH_SHORT).show()
                        Looper.loop()
                    }
                }
                thread.start()
            }
            initialResponse
        }
    }


    private fun updateAccessToken(context: Context) {
        val sp = context.getSharedPreferences("app_data", 0)
        synchronized(this) {
            val tokensCall =  refreshTokenApiInterface.getAccessToken(refresh_token = refreshToken).execute()


            if (tokensCall.isSuccessful) {
                val responseBody = tokensCall.body()
                val editor = sp.edit()

               /* val localTime = SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(tokensCall.headers()["Date"]!!)
                Singleton.setServerTime(localTime!!.time / 1000, context)
*/

                accessToken = responseBody?.accessToken.toString() // TODO: Handel null value
                refreshToken = responseBody?.refreshToken.toString() //TODO: Handel null value
                expiresFromServer = responseBody?.expiresIn ?: 0L
                expireTimeStamp = ConvertMinutesTimeToHHMMString(expiresFromServer)
       /*         editor.putString("access_token", Objects.requireNonNull<ResNewTokens>(responseBody).access_token).apply()
                editor.putString("refresh_token", Objects.requireNonNull<ResNewTokens>(responseBody).refresh_token).apply()
                editor.putLong("expires_in", responseBody!!.expires_in!!).apply()*/
            } else {
                when (tokensCall.code()) {
                    500 -> {
                        val thread = object : Thread() {
                            override fun run() {
                                Looper.prepare()
                                Logger("token",true).log("500-> errorBody: ${tokensCall.errorBody()} , msg: ${tokensCall.message()} ")
                                Looper.loop()
                            }
                        }
                        thread.start()
                    }

                    401 -> {
                        Logger("token",true).log("401-> errorBody: ${tokensCall.errorBody()} , msg: ${tokensCall.message()} ")

//                        Singleton.logOut(context)
                    }
                }
            }

        }
    }


    private fun requestBuilder(chain: Interceptor.Chain): Request {
        return chain.request()
            .newBuilder()
            .header("Content-type:", "application/json")
            .header("Authorization", "Bearer $accessToken")
            .build()
    }

/*
    private fun accessTokenApi(): RefreshTokenApiInterface {
*/
/*        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY*//*


        val dispatcher = Dispatcher()
        dispatcher.maxRequests = 1

        val client = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .dispatcher(dispatcher)
            .readTimeout(100, TimeUnit.SECONDS).build()
        client.dispatcher.cancelAll()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)//BuildConfig.API_URL
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(APIService::class.java)
    }
*/
}
