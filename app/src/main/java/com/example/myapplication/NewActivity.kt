package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity() {

    private lateinit var etPhoneNumber: EditText
    private lateinit var etPwd: EditText
    private lateinit var btnLogIn: Button
    private lateinit var txtForgotPwd: TextView
    private lateinit var txtRegYou: TextView

    private val validPhoneNumber = "0123456789"
    private val validPwd = "thanos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        title = "Log-In"

        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etPwd = findViewById(R.id.etPwd)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgotPwd = findViewById(R.id.txtForgotPwd)
        txtRegYou = findViewById(R.id.txtRegYou)

        btnLogIn.setOnClickListener {
            val mobNumber = etPhoneNumber.text.toString()
            val pwd = etPwd.text.toString()
            if (mobNumber == validPhoneNumber && pwd == validPwd) {
                val intent = Intent(this@NewActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(
                    this@NewActivity,
                    "What the hell is wrong with you bro? try again!",
                    Toast.LENGTH_SHORT
                ).show()
                etPwd.text.clear()
            }
        }
    }

    /*
    override fun onClick(p0: View?) {
    Toast.makeText(this@NewActivity,
    "We clicked this button",
    Toast.LENGTH_LONG).show()
    }
    */
}