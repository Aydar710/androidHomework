package com.example.aydar.editingusersprofile

import android.app.*
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_music.*

class MusicService : Service() {
    val CONST_ACTION_MAIN = "ACTION_MAIN"
    val CONST_ACTION_PLAY = "ACTION_PLAY"
    val CONST_ACTION_PAUSE = "ACTION_PAUSE"
    val CONST_ACTION_NEXT = "ACTION_NEXT"
    val CONST_ACTION_PREV = "ACTION_PREV"
    var currentSong = 0

    private val mBinder = MyBinder()
    private var mediaPlayer: MediaPlayer? = null
    private var currentPosition: Int = 0
    private val playList: ArrayList<Song> = Song.songs
    private lateinit var listener: Callback
    var imagePlay : ImageView = MainActivity().image_play


    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    inner class MyBinder : Binder() {
        internal
        val service: MusicService
            get() = this@MusicService
    }


    fun playOrStopMusic() {
        if (mediaPlayer == null) {
            launchForeground()
            mediaPlayer = MediaPlayer.create(this, R.raw.billiejean)
            mediaPlayer?.start()
        } else if (mediaPlayer != null && !mediaPlayer!!.isPlaying) {
            mediaPlayer?.seekTo(currentPosition)
            mediaPlayer?.start()
            //TODO поменять иконку stop на play
            imagePlay.setImageResource(R.drawable.play)
        } else if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
            mediaPlayer?.let {
                it.pause()
                currentPosition = it.currentPosition
            }
            //TODO поменять иконку play на stop
            imagePlay.setImageResource(R.drawable.pause);
        }
    }

    fun pauseMusic() {
        mediaPlayer?.let {
            it.pause()
            currentPosition = it.currentPosition
        }

    }

    fun playNextSong() {
        if (currentSong + 1 >= playList.size) {
            currentSong = 0
            playSpecificMusic(currentSong)
        } else {
            playSpecificMusic(currentSong + 1)
        }
    }

    fun playPreviousSong() {
        if (currentSong - 1 < 0) {
            currentSong = playList.size - 1
            playSpecificMusic(currentSong)
            listener.changeData(currentSong)
        } else {
            playSpecificMusic(currentSong - 1)
        }
    }


    private fun launchForeground() {

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

        val notificationIntent: Intent = Intent(this, MainActivity::class.java)
        notificationIntent.setAction(CONST_ACTION_MAIN)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)

        val previousIntent = Intent(this, MusicService::class.java)
        previousIntent.setAction(CONST_ACTION_PREV)
        val pPreviousIntent: PendingIntent = PendingIntent.getService(this, 0, previousIntent, 0)

        val playIntent = Intent(this, MusicService::class.java)
        playIntent.setAction(CONST_ACTION_PLAY)
        val pPlayIntent: PendingIntent = PendingIntent.getService(this, 0, playIntent, 0)

        val nextIntent = Intent(this, MusicService::class.java)
        nextIntent.setAction(CONST_ACTION_NEXT)
        val pNextIntent: PendingIntent = PendingIntent.getService(this, 0, nextIntent, 0)


        val notification: Notification = NotificationCompat.Builder(this)
                .setContentTitle("Music PLayer")
                .setTicker("MPlayer")
                .setContentText("Content Text")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .addAction(android.R.drawable.ic_media_previous, "Previous", pPreviousIntent)
                .addAction(android.R.drawable.ic_media_play, "Play/Pause", pPlayIntent)
                .addAction(android.R.drawable.ic_media_next, "Next", pNextIntent)
                .build()

        startForeground(123, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val songNum: Int? = intent?.getIntExtra(MainActivity.CONST_SONG_NUM, -1)
        if (songNum != null && songNum >= 0) {

            launchForeground()
            playSpecificMusic(songNum)
        }
        if (intent?.action == CONST_ACTION_PLAY) {
            if (mediaPlayer?.isPlaying!!)
                pauseMusic()
            else
                playOrStopMusic()
        }
        if (intent?.action == CONST_ACTION_PREV) {
            playPreviousSong()
        }
        if (intent?.action == CONST_ACTION_NEXT) {
            playNextSong()
        }
        return START_NOT_STICKY;
    }

    private fun playSpecificMusic(position: Int) {
        mediaPlayer?.stop()
        mediaPlayer = MediaPlayer.create(this, playList[position].songResourse)
        mediaPlayer?.start()
        currentSong = position
    }

    fun setListener(listener: Callback) {
        this.listener = listener
    }

    interface Callback {
        fun changeData(p: Int)
    }
}
