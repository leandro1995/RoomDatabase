package com.leandro1995.roomdatabse.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.roomdatabse.R
import com.leandro1995.roomdatabse.model.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserListAdapter constructor(private val userList: MutableList<User>) :
    RecyclerView.Adapter<UserListAdapter.UserListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListHolder {
        return UserListHolder(
            view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_user,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserListHolder, position: Int) {
        holder.itemView.userText.text = userList[position].user
    }

    class UserListHolder constructor(view: View) : RecyclerView.ViewHolder(view)
}