package com.soumeru.servicesprac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soumeru.servicesprac.service.MyIntentService
import com.soumeru.servicesprac.service.MyService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            /*Intent(this, MyIntentService::class.java).also {
                startService(it)
                textView.text = "Service Starting...!"
            }*/

            Intent(this, MyService::class.java).also {
                startService(it)
                textView.text = "Service Starting...!"
            }
        }

        stopButton.setOnClickListener {
            /*MyIntentService.stopService()
            textView.text = "Service Stopping...!"*/

            Intent(this, MyService::class.java).also {
                stopService(it)
                textView.text = "Service Stopping...!"
            }
        }

        data_btn.setOnClickListener {
            Intent(this, MyService::class.java).also {
                val dataString = txt_data.text.toString()
                it.putExtra("EXTRA_STRING", dataString)
                startService(it)
            }
        }
    }
}