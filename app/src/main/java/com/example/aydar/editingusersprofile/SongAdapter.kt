package com.example.aydar.editingusersprofile

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.aydar.editingusersprofile.R.layout.card_music
import kotlinx.android.synthetic.main.card_music.view.*

class SongAdapter(val songs: ArrayList<Song>) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    private lateinit var listener: Listener

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(card_music, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song: Song = songs.get(position)
        holder.txtSinger.text = song.singer
        holder.txtSong.text = song.song
        holder.image.setImageResource(song.image)

        holder.itemView.setOnClickListener {
            listener.onClick(position)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtSinger = itemView.txt_singer
        var txtSong = itemView.txt_song
        var image: ImageView = itemView.image_song
    }

    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }
}