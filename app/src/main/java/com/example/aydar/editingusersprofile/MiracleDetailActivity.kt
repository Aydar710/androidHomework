package com.example.aydar.editingusersprofile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MiracleDetailActivity : AppCompatActivity() {

    lateinit var txtLocation: TextView
    lateinit var txtDescription: TextView
    lateinit var imageMiracle: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_miracle_detail)

        val miracleNo: Int = intent.extras.getInt(Miracle.EXTRA)
        val miracle: Miracle = Miracle.miracles[miracleNo]

        txtLocation = findViewById(R.id.txt_miracle_location)
        txtDescription = findViewById(R.id.txt_miracle_description)
        imageMiracle = findViewById(R.id.image_miracle_detail)
        txtLocation.text = miracle.location
        txtDescription.text = miracle.description
        imageMiracle.setImageResource(miracle.image)
        setTitle(miracle.name)
    }
}