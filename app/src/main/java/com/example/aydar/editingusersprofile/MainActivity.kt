package com.example.aydar.editingusersprofile

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity(), SongAdapter.Listener {
    companion object {
        var CONST_SONG_NUM: String = "SONG_NUM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Theme(this).changeTheme()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = rv_songs
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val adapter: SongAdapter = SongAdapter(Song.songs)
        adapter.setListener(this)
        recyclerView.adapter = adapter
        createNotificationChannel()
    }

    override fun onClick(position: Int) {
        val intent = Intent(this, MusicActivity::class.java)
        intent.putExtra(CONST_SONG_NUM, position)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_themes -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel name"
            val descriptionText = "Channel Description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("channelid", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                    this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
