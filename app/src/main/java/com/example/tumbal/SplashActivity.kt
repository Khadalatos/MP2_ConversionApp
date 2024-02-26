package com.example.tumbal


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000 // Waktu penundaan dalam milidetik (3 detik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ivlingma = findViewById<ImageView>(R.id.iv_lingma)
        ivlingma.alpha = 0f

        ivlingma.animate().apply {
            duration = 1500
            alpha(1f)
            withEndAction {
                // Membuat penundaan sebelum berpindah ke halaman login
                Handler().postDelayed({
                    val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }, SPLASH_DELAY)
            }
        }
    }
}
