package com.example.adivinaelpersonaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JugadorAdapter(private val dataSet: List<Jugador>) :
    RecyclerView.Adapter<JugadorAdapter.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_jugador, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val jugador = dataSet[position]
        viewHolder.bind(jugador)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int = dataSet.size

    class  ViewHolder(view : View): RecyclerView.ViewHolder(view){

        private var txtJugador = view.findViewById<TextView>(R.id.nombreJugador)

        fun bind(jugador : Jugador) {
            txtJugador.text = jugador.nombreJugador
        }


    }
}