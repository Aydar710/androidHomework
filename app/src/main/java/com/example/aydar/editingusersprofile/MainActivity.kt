package com.example.aydar.editingusersprofile

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

class MainActivity : AppCompatActivity(), AdapterMiracle.Listener {
    override fun onClick(position: Int) {
        val intent: Intent = Intent(this, MiracleDetailActivity::class.java)
        intent.putExtra(Miracle.EXTRA, position)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Miracles")

        val recyclerView : RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter = AdapterMiracle(Miracle.miracles)
        adapter.setListener(this)
        recyclerView.adapter = adapter
    }
}