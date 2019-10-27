package com.example.aydar.editingusersprofile.samokatus.main.model

data class TransactionType(
    val name: String,
    val sum: Int,
    val isPositive: Boolean
) : ViewType
