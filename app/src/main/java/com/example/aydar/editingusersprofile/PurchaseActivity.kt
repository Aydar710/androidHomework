package com.example.aydar.editingusersprofile

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import com.example.aydar.editingusersprofile.samokatus.samokatus.ActivitySamokatus
import kotlinx.android.synthetic.main.activity_purchase.*

class PurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

        setSupportActionBar(include as Toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        inc_footer.setOnClickListener {
            startActivity(Intent(this, ActivitySamokatus::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mnu_purchase_toolbar, menu)
        return true
    }
}
