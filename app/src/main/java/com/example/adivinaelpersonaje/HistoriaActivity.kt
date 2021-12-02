package com.example.adivinaelpersonaje

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoriaActivity: AppCompatActivity() {
    val Partidas = listOf<Partida>(
        Partida(1,"Borre","Daniel",123,"02/12/2021"),
        Partida(2,"Daniel","Borre",321,"03/12/2021"),
        Partida(3,"Daniel","Borre",321,"03/12/2021"),
        Partida(4,"Daniel","Borre",321,"03/12/2021"),
        Partida(5,"Daniel","Borre",321,"03/12/2021")
    )
    override fun onCreate(savedInstanceState: Bundle?){
       super.onCreate(savedInstanceState)
       setContentView(R.layout.historial_layout)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView_Chido)
        recycler.adapter = PartidaAdapter(Partidas)

    }
}