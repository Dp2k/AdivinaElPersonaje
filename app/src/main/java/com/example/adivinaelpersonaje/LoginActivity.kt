package com.example.adivinaelpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val playerName = findViewById<EditText>(R.id.PlayerName)
        val txtView1 = findViewById<TextView>(R.id.textView2)
        SocketHandler.setSocket()
        val mSocket = SocketHandler.getSocket()

        btnSubmit.setOnClickListener{
            mSocket.connect()
            val data = JSONObject()
            data.put("nombre",playerName.text)
            mSocket.emit("login",data)
        }

        mSocket.on("loginStatus"){
            args ->
            if(args[0] != null){
                val msgJson = JSONObject();
                val  mensaje = (args[0]).toString()
                runOnUiThread {
                    Toast.makeText( this, mensaje, Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}