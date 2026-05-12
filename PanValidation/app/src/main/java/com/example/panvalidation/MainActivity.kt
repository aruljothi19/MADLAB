package com.example.panvalidation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etPAN: EditText = findViewById(R.id.etPAN)
        val etPincode: EditText = findViewById(R.id.etPincode)
        val btValidate: Button = findViewById(R.id.btValidate)
        val btClear: Button = findViewById(R.id.btClear)

8
        btClear.setOnClickListener {
            etPAN.text.clear()
            etPincode.text.clear()
        }

        btValidate.setOnClickListener {
            val pan = etPAN.text.toString().trim()
            val pincode = etPincode.text.toString().trim()


            if (pan.isEmpty() || pincode.isEmpty()) {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            val panPattern = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$".toRegex()


            if (!panPattern.matches(pan.uppercase())) {
                Toast.makeText(this, "Enter valid PAN number (10 characters, alphanumeric)", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val pincodePattern = "^[0-9]{6}$".toRegex()
            if (!pincodePattern.matches(pincode)) {
                Toast.makeText(this, "Enter valid 6-digit Pincode", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "PAN and Pincode are valid!", Toast.LENGTH_LONG).show()
        }
    }
}