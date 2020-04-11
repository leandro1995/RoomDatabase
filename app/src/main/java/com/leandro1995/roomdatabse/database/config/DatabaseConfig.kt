package com.leandro1995.roomdatabse.database.config

import android.content.Context
import androidx.room.Room
import com.leandro1995.roomdatabse.config.Setting

object DatabaseConfig {

    lateinit var dataBase: DataBase

    fun instance(context: Context) {
        synchronized(DataBase::class) {
            dataBase =
                Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    Setting.DATABASE_NAME
                ).build()
        }
    }
}