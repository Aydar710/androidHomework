package com.example.aydar.editingusersprofile

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.example.aydar.editingusersprofile.fragments.HomeFragment
import com.example.aydar.editingusersprofile.fragments.RecyclerFragment
import com.example.aydar.editingusersprofile.fragments.ViewPagerFragment
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fargmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fargmentManager.beginTransaction()
        var fragment: Fragment
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = HomeFragment()
                fragmentTransaction.replace(R.id.frame_content, fragment)
                fragmentTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragment = RecyclerFragment()
                fragmentTransaction.replace(R.id.frame_content, fragment)
                fragmentTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragment = ViewPagerFragment()
                fragmentTransaction.replace(R.id.frame_content, fragment)
                fragmentTransaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
