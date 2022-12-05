package com.kr.aldawaa.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AlDawaaApplication:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}