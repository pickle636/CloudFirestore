package com.quizsquiz.cloudfirestore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.quizsquiz.cloudfirestore.R
import com.quizsquiz.cloudfirestore.databinding.UserItemListBinding
import com.quizsquiz.cloudfirestore.models.User

class UsersAdapter(private val users: List<User>) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        return UsersViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_item_list, parent, false))
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.binding.user = users[position]
    }

    inner class UsersViewHolder(val binding: UserItemListBinding) : RecyclerView.ViewHolder(binding.root)
}
