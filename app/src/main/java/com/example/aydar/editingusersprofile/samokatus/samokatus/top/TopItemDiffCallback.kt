package com.example.aydar.editingusersprofile.samokatus.samokatus.top

import androidx.recyclerview.widget.DiffUtil

class TopItemDiffCallback : DiffUtil.ItemCallback<TopItem>() {

    override fun areItemsTheSame(oldItem: TopItem, newItem: TopItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TopItem, newItem: TopItem): Boolean =
        oldItem == newItem
}