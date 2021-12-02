package com.example.adivinaelpersonaje

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray

class HistorialActivity: AppCompatActivity() {
    var Partidas = listOf<Partida>()

    override fun onCreate(savedInstanceState: Bundle?){
       super.onCreate(savedInstanceState)
       setContentView(R.layout.historial_layout)

        val url = "http://guesswho.danielpacheco.com.mx:3000"
        var jsonArrReq : JsonArrayRequest

        val recycler = findViewById<RecyclerView>(R.id.recyclerView_Chido)
        jsonArrReq = JsonArrayRequest(
            Request.Method.GET,url+"/getAllPartidas/",null,
            {  response ->
                val jArr = JSONArray( response.toString())
                for (i in 0 until jArr.length()) {
                    val jo = jArr.getJSONObject(i)
                    Partidas += listOf<Partida>(
                        Partida(jo.getInt("ID"),jo.getString("Ganador"),jo.getString("Perdedor"),jo.getInt("Puntaje"),"Fecha: "+jo.getString("Fecha").substring(0,10)+" Hora: "+jo.getString("Fecha").substring(11,19))
                    )
                }
                recycler.adapter = PartidaAdapter(Partidas)
            }, { error ->
                error.printStackTrace()
            }
        )

        VolleySingleton.getInstance(applicationContext)
            .addToRequestQueue(jsonArrReq)

    }
}