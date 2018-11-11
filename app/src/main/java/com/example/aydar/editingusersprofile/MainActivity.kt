package com.example.aydar.editingusersprofile

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SongAdapter.Listener {

    companion object {
        var CONST_SONG_NUM: String = "SONG_NUM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView: RecyclerView = rv_songs
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter: SongAdapter = SongAdapter(Song.songs)
        adapter.setListener(this)
        recyclerView.adapter = adapter


        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)

    }

    override fun onClick(position: Int) {
        val intent = Intent(this, MusicActivity::class.java)
        intent.putExtra(CONST_SONG_NUM, position)
        startActivity(intent)
    }
}
