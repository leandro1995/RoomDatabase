package com.leandro1995.roomdatabse.app

import android.app.Application
import com.leandro1995.roomdatabse.database.config.DatabaseConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        DatabaseConfig.instance(context = applicationContext)
    }
}