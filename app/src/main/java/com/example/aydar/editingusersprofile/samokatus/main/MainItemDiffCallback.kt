package com.example.aydar.editingusersprofile.samokatus.main

import androidx.recyclerview.widget.DiffUtil
import com.example.aydar.editingusersprofile.samokatus.main.model.ViewType

class MainItemDiffCallback : DiffUtil.ItemCallback<ViewType>() {

    override fun areItemsTheSame(oldItem: ViewType, newItem: ViewType): Boolean = true

    override fun areContentsTheSame(oldItem: ViewType, newItem: ViewType): Boolean = true
}