package com.example.validation

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
        val etUsername: EditText=findViewById(R.id.etUserName)
        val etPinNo: EditText=findViewById(R.id.etPinNo)
        val btLogin: Button=findViewById(R.id.btLogin)
        val btClear: Button=findViewById(R.id.btClear)

        btClear.setOnClickListener{
            etUsername.text.clear()
            etPinNo.text.clear()
        }
        btLogin.setOnClickListener{
            val checkUserName="[a-zA-z]+".toRegex()
            val checkPinNo="[0-9]{4}".toRegex()

            if(checkUserName.matches(etUsername.text.toString()) && checkPinNo.matches(etPinNo.text.toString())){
                Toast.makeText(this,"Success.. ",Toast.LENGTH_LONG).show()
                val intent=Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Invalid UN/PIN",Toast.LENGTH_LONG).show()
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}