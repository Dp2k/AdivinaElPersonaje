package com.example.adivinaelpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    //Declaración de los elementos de activity_login.xml
    private lateinit var btnSubmit:Button
    private lateinit var playerName:EditText
    private lateinit var layoutLogin:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnSubmit = findViewById(R.id.btnSubmit)
        playerName = findViewById(R.id.PlayerName)
        layoutLogin = findViewById(R.id.Login)

        var estatusLogin : Boolean = false

        val mSocket = SocketHandler.getSocket()
        SocketHandler.setSocket()

        btnSubmit.setOnClickListener{
            mSocket.connect()
            val data = JSONObject()
            data.put("nombre",playerName.text)
            mSocket.emit("login",data)

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

    }

}