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
import android.view.View
import kotlinx.android.synthetic.main.activity_music.*
import kotlinx.android.synthetic.main.card_music.*

class MusicActivity : AppCompatActivity(), View.OnClickListener, MusicService.Callback {
    override fun changeData(p: Int) {
        txt_singer2.text = Song.songs[p].singer
        txt_song2.text = Song.songs[p].song
        image_song2.setImageResource(Song.songs[p].image)
    }

    lateinit var musicService: MusicService
    var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music)
        btn_play.setOnClickListener(this)
        btn_pause.setOnClickListener(this)
        btn_next.setOnClickListener(this)
        btn_prev.setOnClickListener(this)
        changeData(getIntent().getIntExtra(MainActivity.CONST_SONG_NUM, 0))

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
            //  val currentPosition = musicService.getCurrentPosition()
            //  var intent = Intent(this, MusicService::class.java)
            //  intent.putExtra("currentPosition", currentPosition);
            //  musicService.onDestroy()
            unbindService(connection)
            isBound = false
            // startService(intent)
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
            R.id.btn_play -> {
                musicService.playMusic()
            }
            R.id.btn_pause -> {
                musicService.pauseMusic()
            }
            R.id.btn_next -> {
                musicService.playNextSong()
                changeData(musicService.currentSong)
            }
            R.id.btn_prev -> {
                musicService.playPreviousSong()
                changeData(musicService.currentSong)
            }
        }
    }



    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel() {
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

    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this, MusicService::class.java)
        stopService(intent)
    }
}
