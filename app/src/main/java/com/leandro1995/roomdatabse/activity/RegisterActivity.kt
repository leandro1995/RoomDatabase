package com.leandro1995.roomdatabse.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leandro1995.roomdatabse.R
import com.leandro1995.roomdatabse.databinding.ActivityRegisterBinding
import com.leandro1995.roomdatabse.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        registerBinding.registerViewModel = registerViewModel

        observers()
    }

    private fun observers() {
        registerViewModel.loginActivityMutable.observe(this, Observer {
            finish()
        })
    }
}
