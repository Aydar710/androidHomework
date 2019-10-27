package com.example.aydar.editingusersprofile.samokatus.samokatus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.aydar.editingusersprofile.R
import com.example.aydar.editingusersprofile.samokatus.samokatus.bot.BotAdapter
import com.example.aydar.editingusersprofile.samokatus.samokatus.top.TopAdapter
import kotlinx.android.synthetic.main.activity_samokatus.*

class ActivitySamokatus : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_samokatus)

        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

        val repository = SamokatusRepository()
        val adapterTop = TopAdapter()
        rv_top.adapter = adapterTop
        adapterTop.submitList(repository.getTopItems())

        val adapterBot = BotAdapter()
        rv_bot.adapter = adapterBot
        adapterBot.submitList(repository.getBotItems())
    }
}
