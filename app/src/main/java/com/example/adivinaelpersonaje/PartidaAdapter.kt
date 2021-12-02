package com.example.adivinaelpersonaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PartidaAdapter(private val dataSet: List<Partida>) :
    RecyclerView.Adapter<PartidaAdapter.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_partida, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val partida = dataSet[position]
        viewHolder.bind(partida)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int = dataSet.size

    class  ViewHolder(view : View): RecyclerView.ViewHolder(view){

        private var txtJugadorGanador = view.findViewById<TextView>(R.id.txt_jugador_ganador)
        private var txtJugadorPerdedor = view.findViewById<TextView>(R.id.txt_jugdor_perdedor)
        private var txtFecha = view.findViewById<TextView>(R.id.txt_fecha)
        private var txtScore = view.findViewById<TextView>(R.id.txt_score)
        fun bind(partida : Partida) {
            txtJugadorGanador.text = partida.JugadorW
            txtJugadorPerdedor.text = partida.JugadorL
            txtFecha.text = partida.Fecha
            txtScore.text = partida.Score.toString()

        }


    }
}