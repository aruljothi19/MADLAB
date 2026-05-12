package com.example.rec_digital_

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etUsername: EditText = findViewById(R.id.etUserName)
        val etPinNo: EditText = findViewById(R.id.etPinNo)
        val btLogin: Button = findViewById(R.id.btLogin)
        val btClear: Button = findViewById(R.id.btClear)

        btClear.setOnClickListener {
            etUsername.text.clear()
            etPinNo.text.clear()
        }

        btLogin.setOnClickListener {
            val email = etUsername.text.toString().trim()
            val password = etPinNo.text.toString().trim()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Both fields are required", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val emailPattern = "[a-zA-Z0-9._-]+@rajalakshmi+\\.edu.in".toRegex()
            if (!emailPattern.matches(email)) {
                Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            val passwordPattern = ("^(?=.*[a-z])" +        // lowercase
                    "(?=.*[A-Z])" +        // uppercase
                    "(?=.*\\d)" +          // digit
                    "(?=.*[@#\$%^&+=!])" + // special char
                    ".{12,}$").toRegex()   // min 12 chars

            if (!passwordPattern.matches(password)) {
                Toast.makeText(
                    this,
                    "Password must be at least 12 chars with uppercase, lowercase, number & special char",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }


            Toast.makeText(this, "Login Successful!", Toast.LENGTH_LONG).show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}