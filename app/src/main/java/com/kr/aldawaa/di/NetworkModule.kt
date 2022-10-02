package com.kr.aldawaa.di

import android.app.Application
import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kr.authentication_datasource.network.ApiInterface
import com.kr.authentication_datasource.network.AuthenticationRepoImp
import com.kr.core.Constants.BASE_URL
import com.kr.network.ConnectivityObserver
import com.kr.network.NetworkConnectivityObserver
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    //logger: HttpLoggingInterceptor,authenticator: TokenAuthenticator,interceptor: NoConnectionInterceptor
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient
            /*       .addInterceptor { chain ->
                       val request: Request = chain.request().newBuilder().addHeader("MobileType", "android").build()
                       chain.proceed(request)
                   }*/
            /*         .authenticator(authenticator)
                     .addInterceptor(interceptor)*/
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)

        /*       if (BuildConfig.DEBUG) {
                   okHttpClient.addInterceptor(logger)
                       .addInterceptor(chuckerInterceptor)
               }*/
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(converterFactory)
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideConnectivityObserver(@ApplicationContext application: Context): NetworkConnectivityObserver {
        return NetworkConnectivityObserver(application)
    }
}