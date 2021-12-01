package com.example.adivinaelpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.*
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    //Declaración de los elementos de activity_login.xml
    private  var CurrentPlayerID: Int = -1

    private lateinit var playerName: EditText
    private lateinit var playerPassword: EditText
    private lateinit var btnSubmit: Button
    private lateinit var loginLayout: LinearLayout
    private lateinit var roomsLayout: LinearLayout
    private lateinit var onlinePlayer: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        playerName = findViewById(R.id.PlayerName)
        playerPassword = findViewById(R.id.contraseñaJugador)
        btnSubmit = findViewById(R.id.btnSubmit)
        loginLayout = findViewById(R.id.Login)
        roomsLayout = findViewById(R.id.Rooms)
        onlinePlayer = findViewById(R.id.onlinePlayer)

        val queue = Volley.newRequestQueue(this)
        val url = "http://guesswho.danielpacheco.com.mx:3000"
        var jsonObjectRequest : JsonObjectRequest

        /*
        val jsonObject2 =JSONObject();
        jsonObject2.put("id_jugador","5")
        jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url+"/getPlayerInfo/",jsonObject2,
            {  response ->
                onlinePlayer.text = response.get("nombre").toString()
                println(response)
            }, { error ->
                error.printStackTrace()
            }
        )
        queue.add(jsonObjectRequest)
*/


        btnSubmit.setOnClickListener{
            val jsonObject =JSONObject();
            jsonObject.put("jugador",playerName.text)
            jsonObject.put("contraseña",playerPassword.text)
            jsonObjectRequest = JsonObjectRequest(url+"/login/",jsonObject,
                {  response ->
                    println(response)
                    Toast.makeText( this,response.get("msg").toString(), Toast.LENGTH_SHORT).show();
                    if(response.get("msg").toString() == "El jugador a entrado"){
                        CurrentPlayerID = Integer.parseInt(response.get("idPlayer").toString())
                        roomsLayout.visibility = View.VISIBLE
                        loginLayout.visibility = View.GONE

                    }
                }, { error ->
                    error.printStackTrace()
                }
            )
            queue.add(jsonObjectRequest)
        }




    }

}