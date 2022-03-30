package com.example.myweek6task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myweek6task.data.UserData
import com.example.myweek6task.databinding.RecyclerViewBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var userData = mutableListOf<UserData>()

    inner class ViewHolder(val binding: RecyclerViewBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return userData.size
    }
}