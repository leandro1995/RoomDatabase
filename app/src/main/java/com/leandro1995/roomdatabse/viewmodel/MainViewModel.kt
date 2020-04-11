package com.leandro1995.roomdatabse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.roomdatabse.activity.RegisterActivity
import com.leandro1995.roomdatabse.activity.UserListActivity
import com.leandro1995.roomdatabse.database.config.DatabaseConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    var user = ""
    var password = ""

    val registerActivityMutable: MutableLiveData<Class<RegisterActivity>> by lazy {
        MutableLiveData<Class<RegisterActivity>>()
    }

    val userListActivityMutable: MutableLiveData<Class<UserListActivity>> by lazy {
        MutableLiveData<Class<UserListActivity>>()
    }

    fun verifyUser() {
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val userList =
                    DatabaseConfig.dataBase.userDao().userList(user = user, password = password)

                if (userList.size != 0) {
                    userListActivityMutable.postValue(UserListActivity::class.java)
                }
            }
        }
    }

    fun registerUser() {
        registerActivityMutable.value = RegisterActivity::class.java
    }
}