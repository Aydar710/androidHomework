package com.example.aydar.editingusersprofile.samokatus.main

import com.example.aydar.editingusersprofile.samokatus.main.model.DateType
import com.example.aydar.editingusersprofile.samokatus.main.model.TransactionType
import com.example.aydar.editingusersprofile.samokatus.main.model.ViewType

class MainRepository {

    fun getItems(): List<ViewType> =
        listOf(
            DateType("ВЧЕРА"),
            TransactionType("Зарплата", 1234, true),
            TransactionType("Вывод денег", 550, false),
            DateType("29 СЕНТЯБРЯ, ПН"),
            TransactionType("Зарплата", 1234, true),
            TransactionType("Вывод денег", 550, false)
        )

}