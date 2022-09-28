package com.kr.aldawaa.di

import com.kr.authentication_datasource.network.ApiInterface
import com.kr.authentication_datasource.network.AuthenticationRepoImp
import com.kr.core.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object AppModule {
    @Module
    @InstallIn(SingletonComponent::class)

    object AppModule {
        @Provides
        @ActivityRetainedScoped
        fun provideCoinRepository(api: ApiInterface): AuthenticationRepoImp {
            return AuthenticationRepoImp(api)
        }



        @Provides
        @Singleton
        fun provideLogger(): Logger {
            return Logger(
                tag = "AppDebug",
                isDebug = true
            )
        }
    }


}