package com.example.tumbal

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SuhuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suhu)

        val editTextTemperature = findViewById<EditText>(R.id.editTextTemperature)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val spinnerConversionType = findViewById<Spinner>(R.id.spinnerConversionType)

        val conversionTypes = arrayOf("Celsius to Fahrenheit", "Fahrenheit to Celsius",
            "Celsius to Reamur", "Reamur to Celsius",
            "Celsius to Kelvin", "Kelvin to Celsius")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerConversionType.adapter = adapter

        buttonConvert.setOnClickListener {
            val inputText = editTextTemperature.text.toString()
            if (inputText.isNotEmpty()) {
                val temperatureValue = inputText.toDouble()
                val selectedConversion = spinnerConversionType.selectedItemPosition
                val result: Double = when (selectedConversion) {
                    0 -> celsiusToFahrenheit(temperatureValue)
                    1 -> fahrenheitToCelsius(temperatureValue)
                    2 -> celsiusToReamur(temperatureValue)
                    3 -> reamurToCelsius(temperatureValue)
                    4 -> celsiusToKelvin(temperatureValue)
                    5 -> kelvinToCelsius(temperatureValue)
                    else -> 0.0
                }
                textViewResult.text = "Result: $result"
            } else {
                textViewResult.text = "Please enter a valid temperature"
            }
        }
    }

    private fun celsiusToFahrenheit(celsius: Double): Double {
        return (celsius * 9 / 5) + 32
    }

    private fun fahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) * 5 / 9
    }

    private fun celsiusToReamur(celsius: Double): Double {
        return celsius * 4 / 5
    }

    private fun reamurToCelsius(reamur: Double): Double {
        return reamur * 5 / 4
    }

    private fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273.15
    }

    private fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }
}

