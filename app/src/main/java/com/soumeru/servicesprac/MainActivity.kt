package com.soumeru.servicesprac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soumeru.servicesprac.service.MyIntentService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                textView.text = "Service Starting...!"
            }
        }

        stopButton.setOnClickListener {
            MyIntentService.stopService()
            textView.text = "Service Stopping...!"
        }
    }
}