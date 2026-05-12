package com.example.androidfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    lateinit var btnBasic: Button
    lateinit var btnMark: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBasic = findViewById(R.id.btnBasic)
        btnMark = findViewById(R.id.btnMark)

        btnBasic.setOnClickListener {
            loadFragment(StudentBasicFragment())
        }

        btnMark.setOnClickListener {
            loadFragment(StudentMarkFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}