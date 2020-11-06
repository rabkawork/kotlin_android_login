package com.rab.kotlin_sharedpreferences

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.rab.kotlin_sharedpreferences.Helper.SharedPreferences
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity() {

    lateinit var username: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val session:SharedPreferences = SharedPreferences(this)

        sess_username.setText("Welcome, " + session.getString("username"))

        btnLogout.setOnClickListener {
            session.clear()
            gotoHomePage()
        }
    }


    fun gotoHomePage(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}