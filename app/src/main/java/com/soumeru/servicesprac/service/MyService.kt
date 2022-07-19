package com.soumeru.servicesprac.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService: Service() {

    init {
        Log.d(MyService::class.java.name, "Service started...!")
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_STRING")
        dataString?.let {
            Log.d(MyService::class.java.name, dataString.toString())
        }
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(MyService::class.java.name, "Service stopped...!")
    }
}