package com.example.adivinaelpersonaje

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnjugar:Button
    private lateinit var btnHistorial:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_inicio)
        btnjugar = findViewById(R.id.Game1vs1)
        btnHistorial = findViewById(R.id.historiaPartidas)

        btnjugar.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }

        btnHistorial.setOnClickListener{
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}