package com.jerryhong.ithelpsideproject

import android.app.Application
import com.jerryhong.ithelpsideproject.core.AppDataManager
import com.jerryhong.ithelpsideproject.core.AppDataManagerImpl

class AppApplication : Application() {

    private lateinit var appDataManager: AppDataManager

    override fun onCreate() {
        super.onCreate()
        appDataManager = AppDataManagerImpl(this)
    }


    fun getAppDataManager() = appDataManager
}