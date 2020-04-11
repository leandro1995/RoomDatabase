package com.leandro1995.roomdatabse.database.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.leandro1995.roomdatabse.BuildConfig
import com.leandro1995.roomdatabse.database.dao.UserDao
import com.leandro1995.roomdatabse.model.User

@Database(entities = [User::class], version = BuildConfig.VERSION_CODE)
abstract class DataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
}