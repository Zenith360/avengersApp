package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val welcomeMsg = intent.getStringExtra("Name") ?: "Ali"

        title = "First"

        Toast.makeText(
            this@MainActivity,
            "${welcomeMsg}!",
            Toast.LENGTH_SHORT
        ).show()
    }
}