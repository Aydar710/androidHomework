package com.example.aydar.editingusersprofile


import android.os.Bundle
import android.app.Fragment
import android.preference.PreferenceFragment
import android.support.v7.preference.PreferenceFragmentCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(bundle: Bundle, s: String) {
        // Load the Preferences from the XML file
        addPreferencesFromResource(R.xml.pref)
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        addPreferencesFromResource(R.xml.pref)
//    }
}
