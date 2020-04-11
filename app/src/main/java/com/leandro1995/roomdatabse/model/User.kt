package com.leandro1995.roomdatabse.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "user")
    val user: String,
    @ColumnInfo(name = "password")
    val password: String
)