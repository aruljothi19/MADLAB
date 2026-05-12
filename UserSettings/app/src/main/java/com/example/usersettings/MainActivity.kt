package com.example.usersettings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etAge: EditText
    private lateinit var etBio: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var btnSave: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etAge = findViewById(R.id.etAge)
        etBio = findViewById(R.id.etBio)
        radioGroup = findViewById(R.id.radioGroupColor)
        btnSave = findViewById(R.id.btnSave)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserSettings", Context.MODE_PRIVATE)

        // Load saved data when app opens
        loadData()

        // Save button click
        btnSave.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        val editor = sharedPreferences.edit()

        editor.putString("name", etName.text.toString())
        editor.putString("email", etEmail.text.toString())
        editor.putString("age", etAge.text.toString())
        editor.putString("bio", etBio.text.toString())

        val selectedColorId = radioGroup.checkedRadioButtonId
        editor.putInt("color", selectedColorId)

        editor.apply()

        Toast.makeText(this, "Saved Successfully!", Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        etName.setText(sharedPreferences.getString("name", ""))
        etEmail.setText(sharedPreferences.getString("email", ""))
        etAge.setText(sharedPreferences.getString("age", ""))
        etBio.setText(sharedPreferences.getString("bio", ""))

        val savedColorId = sharedPreferences.getInt("color", -1)
        if (savedColorId != -1) {
            radioGroup.check(savedColorId)
        }
    }
}