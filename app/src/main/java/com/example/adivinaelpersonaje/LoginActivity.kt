package com.example.adivinaelpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.*
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    //Declaración de los elementos de activity_login.xml
    private lateinit var CurrentPlayer:String

    private lateinit var btnSubmit: Button
    private lateinit var btnlogout: Button
    private lateinit var playerName: EditText
    private lateinit var layoutLogin: LinearLayout
    private lateinit var layoutRooms: LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnlogout = findViewById(R.id.Logout)
        playerName = findViewById(R.id.PlayerName)
        layoutLogin = findViewById(R.id.Login)
        layoutRooms = findViewById(R.id.Rooms)
        layoutRooms.visibility= View.GONE


        var estatusLogin : Boolean = false
        SocketHandler.setSocket()
        val mSocket = SocketHandler.getSocket()


        btnSubmit.setOnClickListener{
            mSocket.connect()
            val data = JSONObject()
            data.put("nombre",playerName.text)
            mSocket.emit("login",data)
            CurrentPlayer = playerName.text.toString()
        }

        btnlogout.setOnClickListener{
            val data = JSONObject()
            data.put("Jugador",CurrentPlayer)
            mSocket.emit("Logout",data)
        }

        mSocket.on("loginStatus"){
            args ->
            if(args[0] != null){
                val json_Array = JSONArray(args)
                val jsonObject = json_Array.getJSONObject(0)
                val msg : String = jsonObject.getString("mensaje")
                val estatus: Boolean = jsonObject.getBoolean("estatus")
                estatusLogin = estatus
                runOnUiThread {
                    Toast.makeText( this, msg, Toast.LENGTH_SHORT).show();
                    if (!estatusLogin){
                        layoutLogin.visibility= View.VISIBLE
                    }else{
                        layoutLogin.visibility= View.GONE
                    }
                }
            }
        }

        mSocket.on("Logout"){
            layoutLogin.visibility = View.VISIBLE
            layoutRooms.visibility = View.GONE
            CurrentPlayer = ""
        }

    }

}