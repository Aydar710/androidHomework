package com.example.aydar.editingusersprofile

import java.util.ArrayList

class Song(val singer: String, val song: String, val image: Int, val songResourse: Int) {
    companion object {
        var songs: ArrayList<Song> = arrayListOf(
                Song("Michael Jackson", "Billie Jean", R.drawable.billie_jean, R.raw.billiejean),
                Song("Nirvana", "Smells like teen spirit", R.drawable.smells_like, R.raw.smellslike),
                Song("Imagine Dragons", "Believer", R.drawable.believer, R.raw.believer),
                Song("Bon Jovi", "It's my life", R.drawable.itsmylife, R.raw.itsmylife),
                Song("Nirvana", "Sappy", R.drawable.sappy, R.raw.sappy)
        )
    }
}