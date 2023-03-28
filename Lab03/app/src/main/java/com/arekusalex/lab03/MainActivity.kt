package com.arekusalex.lab03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var fiveCents: ImageView
    private lateinit var tenCents: ImageView
    private lateinit var quarter: ImageView
    private lateinit var oneDollar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setListener()
    }


    private fun binding() {
        resultTextView = findViewById(R.id.quantity_text_view)
        fiveCents = findViewById(R.id.five_cents)
        tenCents = findViewById(R.id.ten_cents)
        quarter = findViewById(R.id.quarter)
        oneDollar = findViewById(R.id.one_dollar)
    }

    private fun setListener(){
        fiveCents.setOnClickListener {
            result(0.05)
        }
        tenCents.setOnClickListener {
            result(0.1)
        }
        quarter.setOnClickListener {
            result(0.25)
        }
        oneDollar.setOnClickListener {
            result(1.0)
        }
    }

    private fun result(number: Double) {
        var cantidad = resultTextView.text.toString().toDouble()
        cantidad += number
        val round = (cantidad * 1000.0).roundToInt() / 1000.0
        resultTextView.text = round.toString()

    }
}