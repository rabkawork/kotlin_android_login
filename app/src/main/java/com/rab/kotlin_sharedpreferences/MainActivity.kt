package com.rab.kotlin_sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.rab.kotlin_sharedpreferences.Helper.SharedPreferences
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnLogin

class MainActivity : AppCompatActivity() {


    lateinit var username:EditText
    lateinit var password:EditText
    lateinit var btnSignIn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.etUsername)
        password = findViewById(R.id.etPassword)
        btnSignIn  = findViewById(R.id.btnLogin)
        val session:SharedPreferences=SharedPreferences(this)

        // check existing session
        if(session.isLoggedIn("username") == true) {
            gotoDashboard()
        }

        btnSignIn.setOnClickListener {

            val userValue = username.editableText.toString()
            val passValue = password.editableText.toString()

            // simple validation
            if (userValue.isEmpty() or passValue.isEmpty()) {
                Toast.makeText(this@MainActivity,"Please fill username and password form first",Toast.LENGTH_SHORT).show()
            }
            else{
                session.save("username",userValue)
                gotoDashboard()
            }
        }
    }

    fun gotoDashboard(){
        startActivity(Intent(this, DashboardActivity::class.java))
    }
}