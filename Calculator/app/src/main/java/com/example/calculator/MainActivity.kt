package com.example.calculator

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

        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val resultText = findViewById<TextView>(R.id.resultText)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val subBtn = findViewById<Button>(R.id.subBtn)
        val mulBtn = findViewById<Button>(R.id.mulBtn)
        val divBtn = findViewById<Button>(R.id.divBtn)

        addBtn.setOnClickListener {
            calculate(num1, num2, resultText, "+")
        }

        subBtn.setOnClickListener {
            calculate(num1, num2, resultText, "-")
        }

        mulBtn.setOnClickListener {
            calculate(num1, num2, resultText, "*")
        }

        divBtn.setOnClickListener {
            calculate(num1, num2, resultText, "/")
        }
    }

    private fun calculate(
        num1: EditText,
        num2: EditText,
        resultText: TextView,
        operator: String
    ) {

        val n1 = num1.text.toString()
        val n2 = num2.text.toString()

        if (n1.isEmpty() || n2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val number1 = n1.toDouble()
        val number2 = n2.toDouble()

        val result = when (operator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> {
                if (number2 != 0.0) {
                    number1 / number2
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> 0.0
        }

        resultText.text = "Result: $result"
    }
}