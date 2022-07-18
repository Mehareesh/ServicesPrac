package com.soumeru.servicesprac.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyService") {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: MyIntentService private set
        var isRunning = false

        fun stopService() {
            Log.d(MyIntentService::class.java.name, "Service is stopped...!")
            isRunning = false
            instance.stopSelf()
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.e(MyIntentService::class.java.name, "Service is running on ")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}