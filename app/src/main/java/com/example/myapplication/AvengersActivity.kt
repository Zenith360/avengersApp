package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {

    private lateinit var etMsg: EditText
    private lateinit var btnEnd: Button
    private lateinit var btnSignOut: Button

    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avengers)

        val welcomeMsg = sharedPreferences.getString("SP_Name", "Welcome!")

        Toast.makeText(
            this@AvengersActivity,
            "${welcomeMsg}!",
            Toast.LENGTH_SHORT
        ).show()

        btnEnd = findViewById(R.id.btnEnd)
        etMsg = findViewById(R.id.etMsg)
        btnSignOut = findViewById(R.id.btnSignOut)

        btnEnd.setOnClickListener {

            val msgToSend = etMsg.text.toString()

            println(msgToSend)

            val intent = Intent(this@AvengersActivity, MessageActivity::class.java)

            intent.putExtra("msg", msgToSend)

            startActivity(intent)
        }

        btnSignOut.setOnClickListener {

            sharedPreferences.edit().clear().apply()

            val intent = Intent(this@AvengersActivity, LogInActivity::class.java)

            startActivity(intent)

            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        etMsg.text.clear()
    }
}