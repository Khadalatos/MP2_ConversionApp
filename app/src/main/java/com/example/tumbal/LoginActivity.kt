package com.example.tumbal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button

    // Tentukan username dan password yang valid
    private val validUsername = "admin"
    private val validPassword = "admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi view
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

        // Tambahkan OnClickListener ke tombol login
        buttonLogin.setOnClickListener {
            // Dapatkan teks yang dimasukkan oleh pengguna
            val usernameInput = editTextUsername.text.toString()
            val passwordInput = editTextPassword.text.toString()

            // Periksa apakah input pengguna sesuai dengan kriteria login
            if (usernameInput == validUsername && passwordInput == validPassword) {
                // Jika sesuai, buat Intent untuk berpindah ke MainActivity
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish() // Selesai login activity agar tidak kembali lagi saat tombol back ditekan
            } else {
                // Jika tidak sesuai, berikan pesan kesalahan kepada pengguna
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

