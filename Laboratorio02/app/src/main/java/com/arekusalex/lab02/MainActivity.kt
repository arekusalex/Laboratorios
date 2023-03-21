package com.arekusalex.lab02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var actionResultButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var weightResultTextView: TextView
    private lateinit var rangeTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding()
        setListener()
    }

    private fun binding() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        actionResultButton = findViewById(R.id.calculate_button)
        resultTextView = findViewById(R.id.bmi_result_text_view)
        weightResultTextView = findViewById(R.id.bmi_weight_text_view)
        rangeTextView = findViewById(R.id.normal_range_text_view)
    }

    private fun setListener() {
        actionResultButton.setOnClickListener {
            val weight = weightEditText.text.toString()
            val height = heightEditText.text.toString()

            if (weight.isNullOrEmpty()) {
                Toast.makeText(this, "El dato esta vacio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (height.isNullOrEmpty()) {
                Toast.makeText(this, "El dato esta vacio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val bmi = (weight.toFloat()/(height.toFloat() * height.toFloat())) * 10000

            result(bmi)
        }
    }

    private fun result(number: Float) {
        resultTextView.text = number.toString()
        resultTextView.isVisible = true
        rangeTextView.text = "(Normal range is 18.5 - 24.9)"
        rangeTextView.isVisible = true


        if(number < 18.5) {
            weightResultTextView.text = "Underweight"
            weightResultTextView.setTextColor(ContextCompat.getColor(this, R.color.under_weight))
            weightResultTextView.isVisible = true
        }

        if(number in 18.5 .. 24.99) {
            weightResultTextView.text = "Healthy"
            weightResultTextView.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
            weightResultTextView.isVisible = true
        }

        if(number in 25.0 .. 29.99) {
            weightResultTextView.text = "Overweight"
            weightResultTextView.setTextColor(ContextCompat.getColor(this, R.color.over_weight))
            weightResultTextView.isVisible = true
        }

        if(number > 30) {
            weightResultTextView.text = "Obese"
            weightResultTextView.setTextColor(ContextCompat.getColor(this, R.color.obese))
            weightResultTextView.isVisible = true
        }
    }
}