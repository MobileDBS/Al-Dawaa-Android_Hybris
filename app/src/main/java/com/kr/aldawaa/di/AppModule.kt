package com.kr.aldawaa.di

import com.kr.core.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

object AppModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

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