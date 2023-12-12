package com.example.currency.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.currency.myapplication.R
import com.example.currency.myapplication.domain.User

class UserAdapter(private val glideManager: RequestManager) : ListAdapter<User, UserVH>(getDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
            .let(::UserVH)
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = getItem(position)
        holder.name.text = user.name
        glideManager.load(user.avatarUrl)
            .into(holder.avatar)
    }

    companion object {
        fun getDiff() = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
        }
    }
}