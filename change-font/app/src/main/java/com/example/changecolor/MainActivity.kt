package com.example.changecolor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.graphics.Typeface
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.btnChange)

        button.setOnClickListener {

            // Change color
            textView.setTextColor(Color.RED)

            // Change font style
            textView.setTypeface(null, Typeface.BOLD_ITALIC)

            // Show toast
            Toast.makeText(this, "Style Changed!", Toast.LENGTH_SHORT).show()
        }
    }
}
