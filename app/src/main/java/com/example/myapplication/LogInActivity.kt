package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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

    private lateinit var sharedPreferences: SharedPreferences
    private val validPasswords = arrayOf("steve", "bruce", "tony", "natasha", "t'challa", "thanos")
    private val validPhoneNumber = "0123456789"
//    private val validPwd = "thanos"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("Logged_In", false)
        val welcomeMsg = sharedPreferences.getString("SP_Name", "Welcome Thanos!")

        setContentView(R.layout.activity_login)

        val intent = Intent(this@LogInActivity, AvengersActivity::class.java)

        if (isLoggedIn) {
            startActivity(intent)
            finish()
        }

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

                sharedPreferences.edit().putBoolean("Logged_In", true).apply()
                sharedPreferences.edit().putString("SP_Name", avengerName).apply()

                startActivity(intent)
            } else {
                Toast.makeText(
                    this@LogInActivity,
                    "Username: 0123456789 Pwd: thanos (experiment with the pwd)",
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