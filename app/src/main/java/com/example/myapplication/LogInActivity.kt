package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LogInActivity : AppCompatActivity() {

    private lateinit var etPhoneNumber: EditText
    private lateinit var etPwd: EditText
    private lateinit var btnLogIn: Button
    private lateinit var txtForgotPwd: TextView
    private lateinit var txtRegYou: TextView
    private val validPasswords = arrayOf("steve", "bruce", "tony", "natasha", "t'challa", "thanos")

    private val validPhoneNumber = "0123456789"
//    private val validPwd = "thanos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        title = "Log-In"

        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etPwd = findViewById(R.id.etPwd)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtForgotPwd = findViewById(R.id.txtForgotPwd)
        txtRegYou = findViewById(R.id.txtRegYou)

        btnLogIn.setOnClickListener {
            val mobNumber = etPhoneNumber.text.toString()
            val pwd = etPwd.text.toString()
            if (mobNumber == validPhoneNumber && validPasswords.contains(pwd)) {
                val intent = Intent(this@LogInActivity, AvengersActivity::class.java)

                val avengerName: String = "Welcome " + when (pwd) {

                    validPasswords[0] -> "Captain America"
                    validPasswords[1] -> "Hulk"
                    validPasswords[2] -> "Iron Man"
                    validPasswords[3] -> "Black Widow"
                    validPasswords[4] -> "Black Panther"
                    else -> "Thanos"
                }

                intent.putExtra("Name", avengerName)

                startActivity(intent)
            } else {
                Toast.makeText(
                    this@LogInActivity,
                    "What the hell is wrong with you bro? try again!",
                    Toast.LENGTH_SHORT
                ).show()
                etPwd.text.clear()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}