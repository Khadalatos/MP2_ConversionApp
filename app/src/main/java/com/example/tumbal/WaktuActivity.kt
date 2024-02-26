package com.example.tumbal

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WaktuActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waktu)

        val editTextValue = findViewById<EditText>(R.id.editTextValue)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val spinnerConversionType = findViewById<Spinner>(R.id.spinnerConversionType)

        val conversionTypes = arrayOf(
            "Jam to Menit", "Menit to Jam",
            "Jam to Detik", "Detik to Jam",
            "Jam to Hari", "Hari to Jam"
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
                    0 -> jamToMenit(inputValue)
                    1 -> menitToJam(inputValue)
                    2 -> jamToDetik(inputValue)
                    3 -> detikToJam(inputValue)
                    4 -> jamToHari(inputValue)
                    5 -> hariToJam(inputValue)
                    else -> 0.0
                }
                textViewResult.text = "Result: $result"
            } else {
                textViewResult.text = "Please enter a valid value"
            }
        }
    }

    private fun jamToMenit(jam: Double): Double {
        return jam * 60
    }

    private fun menitToJam(menit: Double): Double {
        return menit / 60
    }

    private fun jamToDetik(jam: Double): Double {
        return jam * 3600
    }

    private fun detikToJam(detik: Double): Double {
        return detik / 3600
    }

    private fun jamToHari(jam: Double): Double {
        return jam / 24
    }

    private fun hariToJam(hari: Double): Double {
        return hari * 24
    }
}
