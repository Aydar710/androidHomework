package com.example.aydar.editingusersprofile.fragments

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.*
import com.example.aydar.editingusersprofile.R
import com.example.aydar.editingusersprofile.TabsFragmentAdapter

class ViewPagerFragment : Fragment() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view: View = inflater.inflate(R.layout.fragment_view_pager, container, false)

        tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        viewPager = view.findViewById(R.id.view_pager)

        val tabs: Array<String> = arrayOf("Tab1", "Tab2", "Tab3")
        val fragments : Array<FirstTabFragment.Companion> = arrayOf(FirstTabFragment)

        var adapter : TabsFragmentAdapter = TabsFragmentAdapter(activity?.supportFragmentManager, tabs, fragments)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        return view
    }
}
