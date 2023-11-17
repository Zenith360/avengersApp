package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {

    private lateinit var etMsg : EditText
    private lateinit var btnEnd : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avengers)

        val welcomeMsg = intent.getStringExtra("Name") ?: "Ali"

        Toast.makeText(
            this@AvengersActivity,
            "${welcomeMsg}!",
            Toast.LENGTH_SHORT
        ).show()

        btnEnd = findViewById(R.id.btnEnd)

        btnEnd.setOnClickListener{

            val msgToSend : String? = etMsg.text.toString()

            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)

            intent.putExtra("msg", msgToSend)

            startActivity(intent)
        }
    }
}