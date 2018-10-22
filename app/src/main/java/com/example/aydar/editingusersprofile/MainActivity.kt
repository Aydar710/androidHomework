package com.example.aydar.editingusersprofile

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.TimePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var timePicker: TimePicker
    lateinit var calendar: Calendar
    lateinit var pendingIntent: PendingIntent
    lateinit var alarmManager: AlarmManager

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePicker = findViewById(R.id.time_picker)
        btn_on.setOnClickListener {
            calendar = Calendar.getInstance()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            var intent = Intent(this, Receiver::class.java)
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)

            calendar.set(Calendar.HOUR_OF_DAY, timePicker.hour)
            calendar.set(Calendar.MINUTE, timePicker.minute)

            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val time = calendar.timeInMillis
            Toast.makeText(this
                    , "Будильник поставлен на ${calendar.get(Calendar.HOUR_OF_DAY)}:${calendar.get(Calendar.MINUTE)}"
                    , Toast.LENGTH_SHORT).show()
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
        }

        btn_off.setOnClickListener {
            alarmManager.cancel(pendingIntent)
            Toast.makeText(this, "Будильник остановлен", Toast.LENGTH_SHORT).show()
        }
    }
}
