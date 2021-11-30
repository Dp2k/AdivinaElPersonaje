package com.example.adivinaelpersonaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val lista_nombre1: MutableList<String> = ArrayList()
    private val lista_nombre2: MutableList<String> = ArrayList()
    private val lista_resultados: MutableList<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_result, parent, false)
        getInfo()
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemPlayer1.text = lista_nombre1[position]
        holder.itemPlayer2.text = lista_nombre2[position]
        holder.itemOutcometxt.text = lista_resultados[position]
        holder.itemUsrImg1.setImageResource(R.drawable.usr_blue)
        holder.itemUsrImg2.setImageResource(R.drawable.usr_red)
    }

    override fun getItemCount(): Int {
        return lista_resultados.size
    }

    fun getInfo(){
/*
       for(i in database){
           lista_nombre1.add(database[i].nombre1)
           lista_nombre2.add(database[i].nombre2)
           lista_resultados.add(database[i].resultado)
       }
*/
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemUsrImg1: ImageView
        var itemUsrImg2: ImageView
        var itemOutcometxt: TextView
        var itemPlayer1: TextView
        var itemPlayer2: TextView
        init {
            itemUsrImg1 = itemView.findViewById(R.id.img_player1)
            itemUsrImg2 = itemView.findViewById(R.id.img_player2)
            itemOutcometxt = itemView.findViewById(R.id.txt_outcome)
            itemPlayer1 = itemView.findViewById(R.id.txt_player1)
            itemPlayer2 = itemView.findViewById(R.id.txt_player2)
        }
    }
}