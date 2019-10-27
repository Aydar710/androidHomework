package com.example.aydar.editingusersprofile.samokatus.samokatus.bot

import androidx.annotation.DrawableRes

data class BotItem(
    val id : Int,
    val name: String,
    val description: String,
    @DrawableRes
    val icon: Int
)