package com.example.adivinaelpersonaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class JugadorAdapter(private val dataSet: List<Jugador>, private val id: Int) :
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
        viewHolder.bind(jugador, id)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() : Int = dataSet.size

    class  ViewHolder(view : View): RecyclerView.ViewHolder(view){

        private var txtJugador = view.findViewById<TextView>(R.id.nombreJugador)
        private var btnmsg = view.findViewById<TextView>(R.id.btn_msg)
        private var layout = view.findViewById<LinearLayout>(R.id.item_jugador_layout)
        fun bind(jugador : Jugador,id2: Int) {
            if(jugador.id_jugador != id2){
                txtJugador.text = jugador.nombreJugador
                btnmsg.setOnClickListener{
                    val mSocket = SocketHandler.getSocket()
                    val data = JSONObject()
                    println("Si entro")
                    println(jugador.SocketID)
                    data.put("destinoSocketID",jugador.SocketID);
                    data.put("msg","Quiere Jugar con: ")
                    mSocket.emit("msg privado",data)
                }
            }else{
                layout.visibility = View.GONE
            }
        }


    }
}