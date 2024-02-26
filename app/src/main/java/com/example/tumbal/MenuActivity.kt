package com.example.tumbal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    // Fungsi untuk membuka SuhuActivity
    fun openSuhuActivity(view: View) {
        val intent = Intent(view.context, SuhuActivity::class.java)
        view.context.startActivity(intent)
    }

    // Fungsi untuk membuka JarakActivity
    fun openJarakActivity(view: View) {
        val intent = Intent(view.context, JarakActivity::class.java)
        view.context.startActivity(intent)
    }
    // Fungsi untuk membuka SuhuActivity
    fun openMassaActivity(view: View) {
        val intent = Intent(view.context, MassaActivity::class.java)
        view.context.startActivity(intent)
    }

    // Fungsi untuk membuka SuhuActivity
    fun openWaktuActivity(view: View) {
        val intent = Intent(view.context, WaktuActivity::class.java)
        view.context.startActivity(intent)
    }

    fun openDistanceActivity(view: View) {
        val intent = Intent(view.context, DistanceActivity::class.java)
        view.context.startActivity(intent)
    }


}
