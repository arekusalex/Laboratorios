package com.arekusalex.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var phoneEditText: TextInputEditText
    private lateinit var saveButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

        addListeners()
    }

    private fun bind() {
        saveButton = findViewById(R.id.save_button)

        nameEditText = findViewById(R.id.name_text_input)
        emailEditText = findViewById(R.id.email_text_input)
        phoneEditText = findViewById(R.id.phone_text_input)
    }

    private fun addListeners() {
        saveButton.setOnClickListener {

            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()

            var intent = Intent(MainActivity@this, Info::class.java)
            intent.putExtra(NAME, name)
            intent.putExtra(EMAIL, email)
            intent.putExtra(PHONE, phone)
            startActivity(intent)
        }
    }

    companion object {
        const val NAME = "NAME"
        const val EMAIL = "EMAIL"
        const val PHONE = "PHONE"
    }
}