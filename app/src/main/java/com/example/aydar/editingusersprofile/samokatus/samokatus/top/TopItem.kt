package com.example.aydar.editingusersprofile.samokatus.samokatus.top

import androidx.annotation.DrawableRes

data class TopItem(
    val id : Int,
    @DrawableRes
    val background: Int,
    @DrawableRes
    val icon: Int,
    val text: String
)