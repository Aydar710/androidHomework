package com.example.aydar.editingusersprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import com.example.aydar.editingusersprofile.SettingsFragment

class SettingsActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref)

//        val fragment : SettingsFragment = SettingsFragment()
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.frame, fragment)
//                .commit()


    }
}
