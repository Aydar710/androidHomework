package com.example.aydar.editingusersprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterMiracle.Listener {

    private lateinit var adapter : AdapterMiracle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = rv_miracles
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
         adapter = AdapterMiracle(Miracle.miracles, this)
        adapter.setListener(this)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_recycler, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.menu_sort_by_order -> {
                adapter.sortByOrder()
                return true
            }
            R.id.menu_sort_by_name ->{
                adapter.sortByName()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
    }
}
