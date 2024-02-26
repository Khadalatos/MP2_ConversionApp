package com.example.tumbal

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DistanceActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distance)

        val editTextValue = findViewById<EditText>(R.id.editTextValue)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val spinnerConversionType = findViewById<Spinner>(R.id.spinnerConversionType)

        val conversionTypes = arrayOf(
            "Meter to Centimeter", "Centimeter to Meter",
            "Meter to Kilometer", "Kilometer to Meter",
            "Meter to Milimeter", "Milimeter to Meter"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerConversionType.adapter = adapter

        buttonConvert.setOnClickListener {
            val inputText = editTextValue.text.toString()
            if (inputText.isNotEmpty()) {
                val inputValue = inputText.toDouble()
                val selectedConversion = spinnerConversionType.selectedItemPosition
                val result: Double = when (selectedConversion) {
                    0 -> meterToCentimeter(inputValue)
                    1 -> centimeterToMeter(inputValue)
                    2 -> meterToKilometer(inputValue)
                    3 -> kilometerToMeter(inputValue)
                    4 -> meterToMilimeter(inputValue)
                    5 -> milimeterToMeter(inputValue)
                    else -> 0.0
                }
                textViewResult.text = "Result: $result"
            } else {
                textViewResult.text = "Please enter a valid value"
            }
        }
    }

    private fun meterToCentimeter(meter: Double): Double {
        return meter * 100
    }

    private fun centimeterToMeter(centimeter: Double): Double {
        return centimeter / 100
    }

    private fun meterToKilometer(meter: Double): Double {
        return meter / 1000
    }

    private fun kilometerToMeter(kilometer: Double): Double {
        return kilometer * 1000
    }

    private fun meterToMilimeter(meter: Double): Double {
        return meter * 1000
    }

    private fun milimeterToMeter(milimeter: Double): Double {
        return milimeter / 1000
    }
}
