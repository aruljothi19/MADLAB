package com.example.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minValue:EditText = findViewById(R.id.minValue)
        val maxValue:EditText = findViewById(R.id.maxValue)
        val resultText:TextView = findViewById(R.id.resultText)
        val generateBtn:Button = findViewById(R.id.generateBtn)

        generateBtn.setOnClickListener {

            val minText = minValue.text.toString()
            val maxText = maxValue.text.toString()

            if (minText.isEmpty() || maxText.isEmpty()) {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val min = minText.toInt()
            val max = maxText.toInt()

            if (min > max) {
                Toast.makeText(this, "Minimum should be less than Maximum", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomNumber = Random.nextInt(min, max + 1)

            resultText.text = "Generated Number: $randomNumber"
        }
    }
}