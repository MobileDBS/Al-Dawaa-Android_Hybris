package com.kr.aldawaa.di

import android.app.Application
import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kr.aldawaa.BuildConfig
import com.kr.aldawaa.network.AuthToken
import com.kr.aldawaa.network.RefreshTokenApiInterface
import com.kr.authentication_datasource.network.ApiInterface
import com.kr.categories_datasource.network.CategoriesApiInterface
import com.kr.core.Constants.BASE_URL
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
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideOkHttpClient(
        logger: HttpLoggingInterceptor,
        @ApplicationContext context: Context,
        authInterceptor: AuthToken
    ): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient
            .addInterceptor(authInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(90, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(logger)
        }

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
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
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

    @Provides
    @Singleton
    fun provideTokenInterceptor(
        @ApplicationContext context: Context,
        refreshTokenApiInterface: RefreshTokenApiInterface
    ): AuthToken {
        return AuthToken(context, refreshTokenApiInterface)
    }

    @Provides
    @Singleton
    fun providApiService(retrofit: Retrofit): CategoriesApiInterface {
        return retrofit.create(CategoriesApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideLoggerInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideRefreshTokenApiService(converterFactory: Converter.Factory): RefreshTokenApiInterface {
        val okHttpClient = OkHttpClient().newBuilder()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(converterFactory)
            .baseUrl(BASE_URL)
            .client(okHttpClient.build())
            .build()

        return retrofit.create(RefreshTokenApiInterface::class.java)
    }
//
//    @Provides
//    @Singleton
//    fun provideRefreshTokenApiService(retrofit: Retrofit): RefreshTokenApiInterface {
//        return retrofit.create(RefreshTokenApiInterface::class.java)
//
//
//    }
}
