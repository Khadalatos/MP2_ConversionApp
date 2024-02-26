package com.example.tumbal

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MassaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_massa)

        val editTextValue = findViewById<EditText>(R.id.editTextValue)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val spinnerConversionType = findViewById<Spinner>(R.id.spinnerConversionType)

        val conversionTypes = arrayOf("Kg to Gram", "Gram to Kg", "Kg to Miligram", "Miligram to Kg")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, conversionTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerConversionType.adapter = adapter

        buttonConvert.setOnClickListener {
            val inputText = editTextValue.text.toString()
            if (inputText.isNotEmpty()) {
                val inputValue = inputText.toDouble()
                val selectedConversion = spinnerConversionType.selectedItemPosition
                val result: Double = when (selectedConversion) {
                    0 -> kgToGram(inputValue)
                    1 -> gramToKg(inputValue)
                    2 -> kgToMiligram(inputValue)
                    3 -> miligramToKg(inputValue)
                    else -> 0.0
                }
                textViewResult.text = "Result: $result"
            } else {
                textViewResult.text = "Please enter a valid value"
            }
        }
    }

    private fun kgToGram(kg: Double): Double {
        return kg * 1000
    }

    private fun gramToKg(gram: Double): Double {
        return gram / 1000
    }

    private fun kgToMiligram(kg: Double): Double {
        return kg * 1_000_000
    }

    private fun miligramToKg(miligram: Double): Double {
        return miligram / 1_000_000
    }
}
