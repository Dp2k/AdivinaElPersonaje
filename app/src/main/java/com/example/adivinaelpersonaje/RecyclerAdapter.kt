package com.example.adivinaelpersonaje

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_result, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
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