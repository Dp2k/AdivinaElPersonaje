package com.example.adivinaelpersonaje

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
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
    var Jugadores = listOf<Jugador>()
    private lateinit var playerName: EditText
    private lateinit var playerPassword: EditText
    private lateinit var btnSubmit: Button
    private lateinit var btnLogout: Button
    private lateinit var loginLayout: LinearLayout
    private lateinit var roomsLayout: LinearLayout
    private lateinit var onlinePlayer: TextView

    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        playerName = findViewById(R.id.PlayerName)
        playerPassword = findViewById(R.id.contraseñaJugador)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnLogout = findViewById(R.id.Logout)
        loginLayout = findViewById(R.id.Login)
        roomsLayout = findViewById(R.id.Rooms)
        onlinePlayer = findViewById(R.id.onlinePlayer)

       // val queue = Volley.newRequestQueue(this)
        val url = "http://guesswho.danielpacheco.com.mx:3000"
        var jsonObjectRequest : JsonObjectRequest
        recycler = findViewById(R.id.recyclerView2)
        SocketHandler.setSocket()
        val mSocket = SocketHandler.getSocket()
        recycler.adapter = JugadorAdapter(Jugadores)

        btnLogout.setOnClickListener{

            val jsonObject =JSONObject();
            jsonObject.put("id_jugador",CurrentPlayerID)
            jsonObjectRequest = JsonObjectRequest(url+"/logout/",jsonObject,
                {  response ->
                    //println(response)
                    Toast.makeText( this,response.get("msg").toString(), Toast.LENGTH_SHORT).show();
                }, { error ->
                    error.printStackTrace()
                }
            )
            VolleySingleton.getInstance(applicationContext)
                .addToRequestQueue(jsonObjectRequest)
            val data = JSONObject();
            data.put("id_jugador",CurrentPlayerID);
            mSocket.emit("logout",data)
            //mSocket.disconnect();
            CurrentPlayerID = -1
            playerName.setText("")
            playerPassword.setText("")
            loginActivo()
        }

        mSocket.on("listaJugadores"){
            args ->
            if (args[0] != null){
                runOnUiThread {
                    val jArr = JSONArray( args[0].toString())
                    println(jArr)
                    Jugadores = listOf<Jugador>()
                    for (i in 0 until jArr.length()) {
                        val jo = jArr.getJSONObject(i)
                        
                        Jugadores += listOf<Jugador>(
                            Jugador(jo.getInt("id_jugador"),jo.getString("nombre"),jo.getString("socketID"))
                        )
                    }
                    recycler.adapter = JugadorAdapter(Jugadores)
                }
            }
        }


        btnSubmit.setOnClickListener{
            val jsonObject =JSONObject();
            jsonObject.put("jugador",playerName.text)
            jsonObject.put("contraseña",playerPassword.text)
            jsonObjectRequest = JsonObjectRequest(url+"/login/",jsonObject,
                {  response ->
                    //println(response)
                    Toast.makeText( this,response.get("msg").toString(), Toast.LENGTH_SHORT).show();
                    if(response.get("msg").toString() == "El jugador a entrado"){
                        CurrentPlayerID = Integer.parseInt(response.get("idPlayer").toString())
                        roomsActivo()

                        //Coneccion de socket

                        mSocket.connect()
                        val data = JSONObject();
                        data.put("id_jugador",CurrentPlayerID);
                        mSocket.emit("nuevoJugador",data)



                        //Asi se hace un get
                        jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url+"/getPlayer/?id_jugador="+CurrentPlayerID.toString(),null,
                            {  response ->
                                //println(response)
                                onlinePlayer.text = response.get("nombre").toString()
                            }, { error ->
                                error.printStackTrace()
                            }
                        )

                        VolleySingleton.getInstance(applicationContext)
                            .addToRequestQueue(jsonObjectRequest)
                    }
                }, { error ->
                    error.printStackTrace()
                }
            )
            VolleySingleton.getInstance(applicationContext)
                .addToRequestQueue(jsonObjectRequest)
            println(jsonObjectRequest)

        }

    }

    fun loginActivo(){

        roomsLayout.visibility = View.GONE
        loginLayout.visibility = View.VISIBLE
    }

    fun roomsActivo(){
        roomsLayout.visibility = View.VISIBLE
        loginLayout.visibility = View.GONE
    }

}