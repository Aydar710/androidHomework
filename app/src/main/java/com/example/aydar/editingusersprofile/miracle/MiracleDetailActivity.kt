package com.example.aydar.editingusersprofile.miracle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.aydar.editingusersprofile.R.layout.activity_miracle_detail
import kotlinx.android.synthetic.main.activity_miracle_detail.*

class MiracleDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_miracle_detail)

        val miracleNo: Int = intent.extras.getInt(Miracle.EXTRA)
        val miracle: Miracle = Miracle.miracles.get(miracleNo)

        txt_miracle_location.text = miracle.location
        txt_miracle_order.text = miracle.order.toString()
        txt_miracle_description.text = miracle.description
        image_miracle_detail.setImageResource(miracle.image)

        setTitle(miracle.name)
    }
}
