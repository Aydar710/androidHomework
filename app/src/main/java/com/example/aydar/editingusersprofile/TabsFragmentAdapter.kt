package com.example.aydar.editingusersprofile

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.aydar.editingusersprofile.fragments.FirstTabFragment

class TabsFragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    val tabs: Array<String> = arrayOf("Tab1", "Tab2", "Tab3")

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }

    override fun getItem(position: Int): Fragment? =
            when (position) {
                0 -> {
                    FirstTabFragment.newInstance(tabs[position])
                }
                1 -> {
                    FirstTabFragment.newInstance(tabs[position])
                }
                2 -> {
                    FirstTabFragment.newInstance(tabs[position])
                }
                else -> {
                    println("asdasd")
                    null
                }
            }

    override fun getCount(): Int {
        return tabs.size
    }
}
