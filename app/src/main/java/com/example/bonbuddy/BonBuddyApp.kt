package com.example.bonbuddy

import android.app.Application

class BonBuddyApp : Application() {

    companion object {
        lateinit var appModule: IAppModule
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModule(this)
    }
}