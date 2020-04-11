package com.leandro1995.roomdatabse

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leandro1995.roomdatabse.databinding.ActivityMainBinding
import com.leandro1995.roomdatabse.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainBinding.mainViewModel = mainViewModel

        observers()
    }

    private fun observers() {
        mainViewModel.registerActivityMutable.observe(this, Observer {
            startActivity(Intent(this, it))
        })

        mainViewModel.userListActivityMutable.observe(this, Observer {
            startActivity(Intent(this, it))
        })
    }
}