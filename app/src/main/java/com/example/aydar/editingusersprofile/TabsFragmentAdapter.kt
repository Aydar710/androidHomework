package com.example.aydar.editingusersprofile

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.aydar.editingusersprofile.fragments.FirstTabFragment

class TabsFragmentAdapter(fm: FragmentManager?, val tabs: Array<String>, val fragments: Array<FirstTabFragment.Companion>) : FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }

    override fun getItem(position: Int): Fragment? =
            when (position) {
                0 -> {
                    fragments[0].newInstance(tabs[position]) // *
                }
                1 -> {
                    fragments[0].newInstance(tabs[position]) // *
                }
                2 -> {
                    fragments[0].newInstance(tabs[position]) // *
                }
                else -> {
                    println("asdasd")
                    null
                }
                // * все три фрагмента пустые, думаю, нет смысла создавать 3 одинаковых
            }

    override fun getCount(): Int {
        return tabs.size
    }
}
