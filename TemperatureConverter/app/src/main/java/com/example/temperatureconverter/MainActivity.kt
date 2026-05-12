package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTemp:EditText = findViewById(R.id.inputTemp)
        val resultText:TextView = findViewById(R.id.resultText)

        val cToFBtn:Button = findViewById(R.id.cToFBtn)
        val fToCBtn:Button = findViewById(R.id.fToCBtn)

        cToFBtn.setOnClickListener {
            convertTemperature(inputTemp, resultText, "CtoF")
        }

        fToCBtn.setOnClickListener {
            convertTemperature(inputTemp, resultText, "FtoC")
        }
    }

    private fun convertTemperature(
        input: EditText,
        resultText: TextView,
        type: String
    ) {

        val tempValue = input.text.toString()

        if (tempValue.isEmpty()) {
            Toast.makeText(this, "Please enter temperature", Toast.LENGTH_SHORT).show()
            return
        }

        val temperature = tempValue.toDouble()

        val result = when (type) {
            "CtoF" -> (temperature * 9/5) + 32
            "FtoC" -> (temperature - 32) * 5/9
            else -> 0.0
        }

        // Round to 2 decimal places
        val roundedResult = String.format("%.2f", result)

        resultText.text = "Converted Temperature: $roundedResult"
    }
}