package com.example.aydar.editingusersprofile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.aydar.editingusersprofile.samokatus.main.MainAdapter
import com.example.aydar.editingusersprofile.samokatus.main.MainRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

        val repository = MainRepository()

        val adapter = MainAdapter()
        rv_main.adapter = adapter
        adapter.submitList(repository.getItems())

        btn_get_money.setOnClickListener {
            startActivity(Intent(this, PurchaseActivity::class.java))
        }
    }

}
