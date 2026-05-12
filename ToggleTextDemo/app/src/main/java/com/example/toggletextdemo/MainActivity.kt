package com.example.toggletextdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        val textMessage = findViewById<TextView>(R.id.textMessage)

        toggleButton.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                textMessage.visibility = TextView.VISIBLE
            } else {
                textMessage.visibility = TextView.GONE
            }

        }
    }
}