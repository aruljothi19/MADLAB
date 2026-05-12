package com.example.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    lateinit var btnBasic: Button
    lateinit var btnAdditional: Button
    lateinit var fragmentContainer: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBasic = findViewById(R.id.btnBasic)
        btnAdditional = findViewById(R.id.btnAdditional)
        fragmentContainer = findViewById(R.id.fragmentContainer)

        btnBasic.setOnClickListener {
            fragmentContainer.visibility = View.VISIBLE
            loadFragment(MovieBasicFragment())
        }

        btnAdditional.setOnClickListener {
            fragmentContainer.visibility = View.VISIBLE
            loadFragment(MovieAdditionalFragment())
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}