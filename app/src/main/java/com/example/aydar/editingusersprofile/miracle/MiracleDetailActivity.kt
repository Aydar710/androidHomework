package com.example.aydar.editingusersprofile.miracle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.aydar.editingusersprofile.R.layout.activity_miracle_detail
import kotlinx.android.synthetic.main.activity_miracle_detail.*

class MiracleDetailActivity : AppCompatActivity() {

    lateinit var txtLocation: TextView
    lateinit var txtOrder: TextView
    lateinit var txtDescription: TextView
    lateinit var imageMiracle: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_miracle_detail)

        val miracleNo: Int = intent.extras.getInt(Miracle.EXTRA)
        val miracle: Miracle = Miracle.miracles.get(miracleNo)

        txtLocation = txt_miracle_location
        txtOrder = txt_miracle_order
        txtDescription = txt_miracle_description
        imageMiracle = image_miracle_detail
        txtLocation.text = miracle.location
        txtOrder.text = miracle.order.toString()
        txtDescription.text = miracle.description
        imageMiracle.setImageResource(miracle.image)
        setTitle(miracle.name)
    }
}
