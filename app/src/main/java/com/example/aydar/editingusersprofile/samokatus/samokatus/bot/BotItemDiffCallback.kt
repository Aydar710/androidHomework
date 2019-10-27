package com.example.aydar.editingusersprofile.samokatus.samokatus.bot

import androidx.recyclerview.widget.DiffUtil

class BotItemDiffCallback : DiffUtil.ItemCallback<BotItem>() {

    override fun areItemsTheSame(oldItem: BotItem, newItem: BotItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: BotItem, newItem: BotItem): Boolean =
        oldItem == newItem
}