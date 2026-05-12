package com.example.radiobuttoncolorapp

import android.graphics.Color
import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layout = findViewById<LinearLayout>(R.id.mainLayout)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupColors)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->

            when (checkedId) {

                R.id.radioRed -> {
                    layout.setBackgroundColor(Color.RED)
                }

                R.id.radioGreen -> {
                    layout.setBackgroundColor(Color.GREEN)
                }

                R.id.radioBlue -> {
                    layout.setBackgroundColor(Color.BLUE)
                }

            }

        }

    }
}