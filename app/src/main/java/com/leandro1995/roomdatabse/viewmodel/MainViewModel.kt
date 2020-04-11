package com.leandro1995.roomdatabse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.roomdatabse.activity.RegisterActivity

class MainViewModel : ViewModel() {

    val registerMutable: MutableLiveData<Class<RegisterActivity>> by lazy {
        MutableLiveData<Class<RegisterActivity>>()
    }

    fun registerUser() {
        registerMutable.value = RegisterActivity::class.java
    }
}