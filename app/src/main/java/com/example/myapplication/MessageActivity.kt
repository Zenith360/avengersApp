package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    private lateinit var txtOnlyTxt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        val msgToBeDisplayed = intent.getStringExtra("msg") ?: "Nothing"

        txtOnlyTxt.text = msgToBeDisplayed
    }
}