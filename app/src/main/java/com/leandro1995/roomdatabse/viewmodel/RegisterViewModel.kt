package com.leandro1995.roomdatabse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.roomdatabse.database.config.DatabaseConfig
import com.leandro1995.roomdatabse.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterViewModel : ViewModel() {

    var user = ""
    var password = ""

    val loginActivityMutable: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun registerUser() {
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                DatabaseConfig.dataBase.userDao()
                    .addUser(user = User(user = user, password = password))
            }

            loginActivityMutable.postValue("")
        }
    }
}