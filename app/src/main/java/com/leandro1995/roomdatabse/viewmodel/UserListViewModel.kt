package com.leandro1995.roomdatabse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.roomdatabse.database.config.DatabaseConfig
import com.leandro1995.roomdatabse.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserListViewModel : ViewModel() {

    val userListMutable: MutableLiveData<MutableList<User>> by lazy {
        MutableLiveData<MutableList<User>>()
    }

    fun init() {
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO)
            {
                userListMutable.postValue(DatabaseConfig.dataBase.userDao().userList())
            }
        }
    }
}