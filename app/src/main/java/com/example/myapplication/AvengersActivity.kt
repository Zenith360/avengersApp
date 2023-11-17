package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        val welcomeMsg = intent.getStringExtra("Name") ?: "Ali"

        title = "First"

        Toast.makeText(
            this@AvengersActivity,
            "${welcomeMsg}!",
            Toast.LENGTH_SHORT
        ).show()
    }
}