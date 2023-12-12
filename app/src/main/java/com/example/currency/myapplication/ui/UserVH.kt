package com.example.currency.myapplication.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.myapplication.R

class UserVH(itemView: View): RecyclerView.ViewHolder(itemView) {
    val avatar: ImageView = itemView.findViewById(R.id.avatar)
    val name: TextView = itemView.findViewById(R.id.name)
}