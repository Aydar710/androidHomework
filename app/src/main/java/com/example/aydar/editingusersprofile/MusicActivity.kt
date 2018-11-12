package com.example.aydar.editingusersprofile

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.support.annotation.RequiresApi
import android.support.v7.preference.PreferenceManager
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_music.*

class MusicActivity : AppCompatActivity(), View.OnClickListener, MusicService.Callback {

    override fun changeData(p: Int) {
        txt_singer2.text = Song.songs[p].singer
        txt_song2.text = Song.songs[p].song
        image_song2.setImageResource(Song.songs[p].image)
    }

    lateinit var imagePlay: ImageView
    lateinit var musicService: MusicService
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        Theme(this).changeTheme()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        image_play.setOnClickListener(this)
        image_next.setOnClickListener(this)
        image_prev.setOnClickListener(this)
        changeData(getIntent().getIntExtra(MainActivity.CONST_SONG_NUM, 0))
        imagePlay = image_play
    }

    override fun onStart() {
        val intent = Intent(this, MusicService::class.java)
        val songNum = getIntent().getIntExtra(MainActivity.CONST_SONG_NUM, -1)
        if (songNum >= 0)
            intent.putExtra(MainActivity.CONST_SONG_NUM, songNum)
        startService(intent)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
        if (isBound) {
            unbindService(connection)
            isBound = false
        }
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder: MusicService.MyBinder = service as MusicService.MyBinder
            musicService = binder.service
            musicService.setListener(this@MusicActivity)
            isBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            isBound = false
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.image_play -> {
                if (musicService.isPlayerPlaying()) {
                    imagePlay.setImageResource(R.drawable.play)
                } else if (!musicService.isPlayerPlaying())
                    imagePlay.setImageResource(R.drawable.pause)
                musicService.playOrStopMusic()
            }
            R.id.image_next -> {
                musicService.playNextSong()
                changeData(musicService.currentSong)
                imagePlay.setImageResource(R.drawable.pause)
            }
            R.id.image_prev -> {
                musicService.playPreviousSong()
                changeData(musicService.currentSong)
                imagePlay.setImageResource(R.drawable.pause)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this, MusicService::class.java)
        stopService(intent)
    }
}
