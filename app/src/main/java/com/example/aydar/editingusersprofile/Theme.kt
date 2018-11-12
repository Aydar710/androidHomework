package com.example.aydar.editingusersprofile

import android.content.Context
import android.support.v7.preference.PreferenceManager

class Theme(val context: Context) {
    fun changeTheme(){
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(context)
        val currentTheme = sharedPref.getString("theme", "theme1")
        var themeId = R.style.AppTheme
        when (currentTheme) {
            "theme1" -> {
                themeId = R.style.AppTheme
            }
            "theme2" -> {
                themeId = R.style.AppTheme2
            }
            "theme3" -> {
                themeId = R.style.AppTheme3
            }
        }
        context.setTheme(themeId)
    }
}