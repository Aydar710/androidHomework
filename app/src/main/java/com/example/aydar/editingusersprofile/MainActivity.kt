package com.example.aydar.editingusersprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterMiracle.Listener {

    private lateinit var adapter: AdapterMiracle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = rv_miracles
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        adapter = AdapterMiracle(Miracle.miracles)
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
                sortByOrder()
                return true
            }
            R.id.menu_sort_by_name -> {
                sortByName()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(position: Int) {
        Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
    }

    private fun sortByName() {
        Observable.fromIterable(adapter.miracles)
                .map {
                    it.name = it.name + it.name.length
                    it
                }
                .take(5)
                .toSortedList { o1, o2 -> o1.name.compareTo(o2.name) }
                .doOnSubscribe { progress_bar.visibility = ProgressBar.VISIBLE }
                .doAfterTerminate { progress_bar.visibility = ProgressBar.INVISIBLE }
                .subscribe { miracles ->
                    adapter.submitList(miracles)
                }
    }

    private fun sortByOrder() {
        Observable.fromIterable(adapter.miracles)
                .map {
                    it.name = it.name + it.name.length + "by order"
                    it
                }
                .take(3)
                .toSortedList { o1, o2 -> o1.order - o2.order }
                .doOnSubscribe { progress_bar.visibility = ProgressBar.VISIBLE }
                .doOnSuccess { progress_bar.visibility = ProgressBar.INVISIBLE }
                .subscribe { miracles ->
                    adapter.submitList(miracles)
                }
    }
}
