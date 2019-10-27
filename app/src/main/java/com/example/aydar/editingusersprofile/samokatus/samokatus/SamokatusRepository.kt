package com.example.aydar.editingusersprofile.samokatus.samokatus

import com.example.aydar.editingusersprofile.R
import com.example.aydar.editingusersprofile.samokatus.samokatus.bot.BotItem
import com.example.aydar.editingusersprofile.samokatus.samokatus.top.TopItem

class SamokatusRepository {

    fun getTopItems(): List<TopItem> =
        listOf(TopItem(0, R.drawable.ic_tools_tours, R.drawable.ic_tours, "Подписки"),
            TopItem(1, R.drawable.ic_tools_tours, R.drawable.ic_tours, "Авиабилеты"),
            TopItem(2, R.drawable.ic_tools_tours, R.drawable.ic_tours, "Туры"),
            TopItem(3, R.drawable.ic_tools_tours, R.drawable.ic_tours, "Отели")
        )

    fun getBotItems(): List<BotItem> =
        listOf(BotItem(0, "Круиз с безвиззовой\n" + "Англией – 259€",
            "7 дней в апреле 2019 года - vandrouki", R.drawable.ic_tools_cruise_icon),
            BotItem(0, "Из Москвы в Пекин \uD83C\uDDE8\uD83C\uDDF3\n" + "за 16 800 р. RT (июнь)",
                "MIAT, по пути можно посмотреть столицу Монголии", R.drawable.ic_tools_cruise_icon),
            BotItem(0, "Из Москвы в Пекин \uD83C\uDDE8\uD83C\uDDF3\n" + "за 16 800 р. RT (июнь)",
                "MIAT, по пути можно посмотреть столицу Монголии", R.drawable.ic_tools_cruise_icon))
}