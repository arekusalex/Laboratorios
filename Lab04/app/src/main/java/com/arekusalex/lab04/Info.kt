package com.arekusalex.lab04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Info : AppCompatActivity() {

    private var name = ""
    private var email = ""
    private var phone = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        if( intent != null ){
            intent.extras?.apply {
                name = getString(MainActivity.NAME).toString()
                email = getString(MainActivity.EMAIL).toString()
                phone = getString(MainActivity.PHONE).toString()

                findViewById<TextView>(R.id.name_fill).apply {
                    text = name
                }

                findViewById<TextView>(R.id.email_fill).apply {
                    text = email
                }

                findViewById<TextView>(R.id.phone_fill).apply {
                    text = phone
                }
            }
        }

        val sharing = "Compartiendo contacto: Name: $name Email: $email Phone: $phone"

        findViewById<Button>(R.id.share_button).apply {
            setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, sharing)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }



    }
}