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
        val fargmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fargmentManager.beginTransaction()
        var fragment: Fragment? = null
        var isPressed: Boolean = false
        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = HomeFragment()
                navigate(fragment, fragmentTransaction)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                fragment = RecyclerFragment()
                navigate(fragment, fragmentTransaction)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragment = ViewPagerFragment()
                navigate(fragment, fragmentTransaction)
                return@OnNavigationItemSelectedListener true
            }
            else -> fragmentTransaction.commit()
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun navigate(fragment: Fragment, transaction: FragmentTransaction) {
        transaction.replace(R.id.frame_content, fragment)
        transaction.commit()
    }
}
