package com.leandro1995.roomdatabse.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.roomdatabse.R
import com.leandro1995.roomdatabse.adapter.UserListAdapter
import com.leandro1995.roomdatabse.databinding.ActivityUserListBinding
import com.leandro1995.roomdatabse.model.User
import com.leandro1995.roomdatabse.viewmodel.UserListViewModel

class UserListActivity : AppCompatActivity() {

    private lateinit var userListBinding: ActivityUserListBinding
    private lateinit var userListViewModel: UserListViewModel

    private lateinit var userListAdapter: UserListAdapter
    private lateinit var userListLinearLayoutManager: LinearLayoutManager

    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userListViewModel = ViewModelProvider(this).get(UserListViewModel::class.java)

        userListBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        userListBinding.userListViewModel = userListViewModel

        userListAdapter = UserListAdapter(userList = userList)

        userListLinearLayoutManager = LinearLayoutManager(this)
        userListLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        userListBinding.userRecycler.layoutManager = userListLinearLayoutManager
        userListBinding.userRecycler.adapter = userListAdapter

        observers()
    }

    private fun observers() {
        userListViewModel.init()

        userListViewModel.userListMutable.observe(this, Observer {
            userList.addAll(it)

            userListAdapter.notifyDataSetChanged()
        })
    }
}