package com.example.adivinaelpersonaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class MensajeAdapte(private val dataSet: List<Mensaje>) :
    RecyclerView.Adapter<MensajeAdapte.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_mensaje, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val mensaje = dataSet[position]
        viewHolder.bind(mensaje)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int = dataSet.size

    class  ViewHolder(view : View): RecyclerView.ViewHolder(view){

        private var emisor = view.findViewById<TextView>(R.id.nombreEmisor)
        private var contenido = view.findViewById<TextView>(R.id.contenidoMsg)

        fun bind(mensaje: Mensaje ) {
            emisor.text = mensaje.nombreEmisor
            contenido.text = mensaje.contenido
        }


    }
}