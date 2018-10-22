package com.example.aydar.editingusersprofile


import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver : BroadcastReceiver() {

    @SuppressLint("NewApi")
    override fun onReceive(context: Context, intent: Intent) {
        val notificationHelper = NotificationHelper(context)
        notificationHelper.createNotificationChannel()
        var intent = Intent(context, SecondActivity::class.java)
        notificationHelper.showNotification(intent)
    }
}
