package com.leandro1995.roomdatabse.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.leandro1995.roomdatabse.model.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Query("select * from User")
    fun userList(): MutableList<User>

    @Query("select * from User where user =:user and password =:password")
    fun userList(user: String, password: String): MutableList<User>
}