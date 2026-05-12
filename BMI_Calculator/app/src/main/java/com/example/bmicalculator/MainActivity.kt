package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightInput:EditText = findViewById(R.id.weightInput)
        val heightInput:EditText = findViewById(R.id.heightInput)
        val resultText:TextView = findViewById(R.id.resultText)
        val calcBtn:Button = findViewById(R.id.calcBtn)

        calcBtn.setOnClickListener {

            val weightText = weightInput.text.toString()
            val heightText = heightInput.text.toString()

            if (weightText.isEmpty() || heightText.isEmpty()) {
                Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val weight = weightText.toDouble()
            val height = heightText.toDouble()

            if (height == 0.0) {
                Toast.makeText(this, "Height cannot be zero", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmi = weight / height.pow(2)

            val roundedBMI = String.format("%.2f", bmi)

            val category = when {
                bmi < 18.5 -> "Underweight"
                bmi < 24.9 -> "Normal weight"
                bmi < 29.9 -> "Overweight"
                else -> "Obese"
            }

            resultText.text = "BMI: $roundedBMI\nCategory: $category"
        }
    }
}