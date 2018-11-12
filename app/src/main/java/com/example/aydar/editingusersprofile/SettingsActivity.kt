package com.example.aydar.editingusersprofile

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceActivity
import android.support.v7.preference.PreferenceManager
import android.util.Log

class SettingsActivity : PreferenceActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref)

//        val fragment : SettingsFragment = SettingsFragment()
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.frame, fragment)
//                .commit()

//        supportFragmentManager.beginTransaction()
//                .replace(R.id.frame, SettingsFragment())
//                .commit()
    }

//    override fun onResume() {
//        super.onResume()
//        preferenceScreen.sharedPreferences
//                .registerOnSharedPreferenceChangeListener(this)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        preferenceScreen.sharedPreferences
//                .unregisterOnSharedPreferenceChangeListener(this)
//    }
}
