package com.example.anbessabus

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Get references to the UI components
        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signupLink = findViewById<TextView>(R.id.signupLink)

        // Handle login button click
        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                // Display error message
                emailInput.error = "Email is required"
                passwordInput.error = "Password is required"
            } else {
                // Perform login (e.g., API call or Firebase authentication)
                // Redirect to the Main Activity on success
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Handle signup link click
        signupLink.setOnClickListener {
            // Redirect to a SignupActivity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}
